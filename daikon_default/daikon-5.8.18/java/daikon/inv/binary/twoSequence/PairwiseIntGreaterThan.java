// ***** This file is automatically generated from PairwiseIntComparison.java.jpp

package daikon.inv.binary.twoSequence;

import daikon.*;
import daikon.Quantify.QuantFlags;
import daikon.derive.binary.*;
import daikon.inv.*;
import daikon.inv.binary.twoScalar.*;
import daikon.suppress.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.interning.qual.Interned;
import org.checkerframework.checker.lock.qual.GuardSatisfied;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.plumelib.util.ArraysPlume;
import org.plumelib.util.Intern;
import typequals.prototype.qual.NonPrototype;
import typequals.prototype.qual.Prototype;

/**
 * Represents an invariant between corresponding elements of two sequences of long values. The
 * length of the sequences must match for the invariant to hold. A comparison is made over each
 * {@code (x[i], y[i])} pair. Thus, {@code x[0]} is compared to {@code y[0]},
 * {@code x[1]} to {@code y[1]}, and so forth. Prints as {@code x[] > y[]}.
 */
public class PairwiseIntGreaterThan extends TwoSequence {
  // We are Serializable, so we specify a version to allow changes to
  // method signatures without breaking serialization.  If you add or
  // remove fields, you should change this number to the current date.
  static final long serialVersionUID = 20030822L;

  /** Debug tracer. */
  public static final Logger debug =
    Logger.getLogger("daikon.inv.binary.twoSequence.PairwiseIntGreaterThan");

  // Variables starting with dkconfig_ should only be set via the
  // daikon.config.Configuration interface.
  /** Boolean. True iff PairwiseIntComparison invariants should be considered. */
  public static boolean dkconfig_enabled = Invariant.invariantEnabledDefault;

  static final boolean debugPairwiseIntComparison = false;

  protected PairwiseIntGreaterThan(PptSlice ppt) {
    super(ppt);
  }

  protected @Prototype PairwiseIntGreaterThan() {
    super();
  }

  private static @Prototype PairwiseIntGreaterThan proto = new @Prototype PairwiseIntGreaterThan();

  /** Returns the prototype invariant for PairwiseIntGreaterThan */
  public static @Prototype PairwiseIntGreaterThan get_proto() {
    return proto;
  }

  /** Returns whether or not this invariant is enabled. */
  @Override
  public boolean enabled() {
    return dkconfig_enabled;
  }

  /** PairwiseIntGreaterThan is only valid on integral types. */
  @Override
  public boolean instantiate_ok(VarInfo[] vis) {

    if (!valid_types(vis)) {
      return false;
    }

      if (!(vis[0].type.elementIsIntegral() && vis[1].type.elementIsIntegral())) {
        return false;
      }

    return true;
  }

  /** instantiates the invariant on the specified slice */
  @Override
  protected PairwiseIntGreaterThan instantiate_dyn(@Prototype PairwiseIntGreaterThan this, PptSlice slice) {
    PairwiseIntGreaterThan inv = new PairwiseIntGreaterThan(slice);
    if (logOn()) {
      inv.log("instantiate");
    }
    return inv;
  }

  protected PairwiseIntGreaterThan(PairwiseIntLessThan swapped_pic) {
    super(swapped_pic.ppt);
    if (logOn()) {
      log("Instantiated from resurrect_done_swapped");
    }
  }

  @Pure
  @Override
  public @Nullable DiscardInfo isObviousStatically(VarInfo[] vis) {
    VarInfo var1 = vis[0];
    VarInfo var2 = vis[1];

    DiscardInfo di = SubSequence.isObviousSubSequence(this, var1, var2);
    if (di == null) {
      di = SubSequence.isObviousSubSequence(this, var2, var1);
    }
    if (di != null) {
      Global.implied_noninstantiated_invariants++;
      return di;
    }

    // Don't instantiate if the variables can't have order
    if (!var1.aux.hasOrder() || !var2.aux.hasOrder()) {
      if (debug.isLoggable(Level.FINE)) {
        debug.fine("Not instantitating for because order has no meaning: "
                     + var1.name() + " and " + var2.name());
      }
      return new DiscardInfo(this, DiscardCode.obvious, "Obvious statically since order has no meaning");
    }

    return super.isObviousStatically(vis);
  }

  @Pure
  @Override
  public @Nullable DiscardInfo isObviousDynamically(VarInfo[] vis) {
    DiscardInfo super_result = super.isObviousDynamically(vis);
    if (super_result != null) {
      return super_result;
    }

    // Subsequence invariants are implied by the same invariant over
    // the supersequence
    DiscardInfo di = superseq_implies(vis);
    if (di != null) {
      return di;
    }

    return null;
    }

  /**
   * Checks to see if the same invariant exists over supersequences of these variables:
   *
   * <pre>
   *    (A[] op B[]) ^ (i == j)  &rArr; A[i..] op B[j..]
   *    (A[] op B[]) ^ (i == j)  &rArr; A[..i] op B[..j]
   * </pre>
   */
  private @Nullable DiscardInfo superseq_implies(VarInfo[] vis) {

    // Make sure the variables are SequenceScalarSubsequence with the same start/end
    VarInfo v1 = vis[0];
    VarInfo v2 = vis[1];
    if (!v1.isDerived() || !(v1.derived instanceof SequenceScalarSubsequence)) {
      return null;
    }
    if (!v2.isDerived() || !(v2.derived instanceof SequenceScalarSubsequence)) {
      return null;
    }
    @NonNull SequenceScalarSubsequence der1 = (SequenceScalarSubsequence) v1.derived;
    @NonNull SequenceScalarSubsequence der2 = (SequenceScalarSubsequence) v2.derived;
    if ((der1.from_start != der2.from_start)
        || (der1.index_shift != der2.index_shift))
      return null;

    // Make sure the subscripts are equal
    DiscardInfo di = new DiscardInfo(this, DiscardCode.obvious, "");
    if (!ppt.parent.check_implied_canonical(di, der1.sclvar(), der2.sclvar(),
                                             IntEqual.get_proto()))
      return null;

    // See if the super-sequences have the same invariant
    if (!ppt.parent.check_implied_canonical(di, der1.seqvar(), der2.seqvar(),
                                             PairwiseIntGreaterThan.get_proto()))
      return null;

    // Add in the vis variables to di reason (if they are different)
    di.add_implied_vis(vis);
    return di;
  }

  @Override
  protected Invariant resurrect_done_swapped() {

      return new PairwiseIntLessThan(this);
  }

  /** Returns the class that corresponds to this class with its variable order swapped. */
  public static Class<PairwiseIntLessThan> swap_class() {
    return PairwiseIntLessThan.class;
  }

  @Override
  public String repr(@GuardSatisfied PairwiseIntGreaterThan this) {
    return "PairwiseIntGreaterThan" + varNames() + ": ";
  }

  public String getComparator() {
    return ">";
  }

  @SideEffectFree
  @Override
  public String format_using(@GuardSatisfied PairwiseIntGreaterThan this, OutputFormat format) {

    if (format.isJavaFamily()) {
      return format_java_family(format);
    }

    if (format == OutputFormat.DAIKON) {
      return format_daikon();
    }
    if (format == OutputFormat.ESCJAVA) {
      return format_esc();
    }
    if (format == OutputFormat.SIMPLIFY) {
      return format_simplify();
    }
    if (format == OutputFormat.CSHARPCONTRACT) {
      return format_csharp();
    }

    return format_unimplemented(format);
  }

  public String format_daikon(@GuardSatisfied PairwiseIntGreaterThan this) {
    return var1().name() + " > " + var2().name() + " (elementwise)";
  }

  public String format_esc(@GuardSatisfied PairwiseIntGreaterThan this) {
    String[] form = VarInfo.esc_quantify(var1(), var2());
    return form[0] + "(" + form[1] + " > " + form[2] + ")" + form[3];
  }

  public String format_simplify(@GuardSatisfied PairwiseIntGreaterThan this) {
    String[] form = VarInfo.simplify_quantify(QuantFlags.element_wise(), var1(), var2());
    return form[0] + "(> " + form[1] + " " + form[2] + ")" + form[3];
  }

  public String format_java_family(@GuardSatisfied PairwiseIntGreaterThan this, OutputFormat format) {
    return "daikon.Quant.pairwiseGT(" + var1().name_using(format)
      + ", " + var2().name_using(format) + ")";
  }

  public String format_csharp(@GuardSatisfied PairwiseIntGreaterThan this) {

    String[] split1 = var1().csharp_array_split();
    String[] split2 = var2().csharp_array_split();

    String equals_str;
    String end_str;

    equals_str = " > ";
    end_str = "";

    return "Contract.ForAll(0, " + split1[0] + ".Count(), i => " +  split1[0] + "[i]"  + split1[1] + equals_str + split2[0] + "[i]" + split2[1] + end_str + ")";
  }

  @Override
  public InvariantStatus check_modified(long @Interned [] a1, long @Interned [] a2, int count) {
    assert a1 != null && a2 != null
      : var1() + " " + var2() + " " + FileIO.get_linenum();
    if (a1.length != a2.length || a1.length == 0 || a2.length == 0) {
      // destroyAndFlow();
      return InvariantStatus.FALSIFIED;
    }

    int len = a1.length;
    // int len = Math.min(a1.length, a2.length);

    for (int i = 0; i < len; i++) {
      long v1 = a1[i];
      long v2 = a2[i];
      if (!(v1 > v2) ) {
        //  destroyAndFlow();
        return InvariantStatus.FALSIFIED;
      }
    }
    return InvariantStatus.NO_CHANGE;
  }

    @Override
    public InvariantStatus add_modified(long @Interned [] a1, long @Interned [] a2,
                                        int count) {
      if (logDetail()) {
        log(debug, "saw add_modified (" + Arrays.toString(a1)
             + ", " + Arrays.toString(a2) + ")");
      }
      return check_modified(a1, a2, count);
    }

  @Override
  protected double computeConfidence() {
    // num_elt_values() would be more appropriate
    // int num_values = ((PptSlice2) ppt).num_elt_values();
    int num_values = ppt.num_samples();
    if (num_values == 0) {
      return Invariant.CONFIDENCE_UNJUSTIFIED;
    } else {

      return 1 - Math.pow(.5, num_values);
    }
  }

  @Pure
  @Override
  public boolean isSameFormula(Invariant other) {
    return true;
  }

  @Pure
  @Override
  public boolean isExclusiveFormula(Invariant other) {
    return false;
  }

  // Look up a previously instantiated invariant.
  public static @Nullable PairwiseIntGreaterThan find(PptSlice ppt) {
    assert ppt.arity() == 2;
    for (Invariant inv : ppt.invs) {
      if (inv instanceof PairwiseIntGreaterThan) {
        return (PairwiseIntGreaterThan) inv;
      }
    }
    return null;
  }

  /** Returns a list of non-instantiating suppressions for this invariant. */
  @Pure
  @Override
  public @Nullable NISuppressionSet get_ni_suppressions() {
    return suppressions;
  }

    private static @Nullable NISuppressionSet suppressions = null;

}
