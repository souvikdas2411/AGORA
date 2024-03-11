// ***** This file is automatically generated from Bound.java.jpp

package daikon.inv.unary.scalar;

import daikon.*;
import daikon.inv.*;

  import daikon.inv.binary.sequenceScalar.*;
  import daikon.inv.unary.sequence.*;

import daikon.derive.unary.*;
import daikon.inv.unary.*;
import java.util.*;
import org.checkerframework.checker.interning.qual.Interned;
import org.checkerframework.checker.lock.qual.GuardSatisfied;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.framework.qual.Unused;
import org.plumelib.util.Intern;
import typequals.prototype.qual.NonPrototype;
import typequals.prototype.qual.Prototype;

  /**
   * Represents the invariant {@code x <= c}, where {@code c} is a constant and
   * {@code x} is a long scalar.
   */

// One reason not to combine LowerBound and UpperBound into a single range
// invariant is that they have separate justifications:  one may be
// justified when the other is not.
@SuppressWarnings("UnnecessaryParentheses")  // code generated by macros
public class UpperBound extends SingleScalar {
  // We are Serializable, so we specify a version to allow changes to
  // method signatures without breaking serialization.  If you add or
  // remove fields, you should change this number to the current date.
  static final long serialVersionUID = 20030822L;

  // Variables starting with dkconfig_ should only be set via the
  // daikon.config.Configuration interface.
  /** Boolean. True iff UpperBound invariants should be considered. */
  public static boolean dkconfig_enabled = Invariant.invariantEnabledDefault;
  /**
   * Long integer. Together with the corresponding {@code maximal_interesting} parameter,
   * specifies the range of the computed constant that is ``interesting'' --- the range that should
   * be reported. For instance, setting {@code minimal_interesting} to -1 and
   * {@code maximal_interesting} to 2 would only permit output of UpperBound invariants whose
   * cutoff was one of (-1,0,1,2).
   */
  public static long dkconfig_minimal_interesting = -1;
  /**
   * Long integer. Together with the corresponding {@code minimal_interesting} parameter,
   * specifies the range of the computed constant that is ``interesting'' --- the range that should
   * be reported. For instance, setting {@code minimal_interesting} to -1 and
   * {@code maximal_interesting} to 2 would only permit output of UpperBound invariants whose
   * cutoff was one of (-1,0,1,2).
   */
  public static long dkconfig_maximal_interesting = 2;

  @Unused(when=Prototype.class)
  private UpperBoundCore core;

  @SuppressWarnings("nullness") // circular initialization
  private UpperBound(PptSlice slice) {
    super(slice);
    assert slice != null;
    core = new UpperBoundCore(this);
  }

  private @Prototype UpperBound() {
    super();
    // do we need a core?
  }

  private static @Prototype UpperBound proto = new @Prototype UpperBound();

  /** Returns the prototype invariant for UpperBound */
  public static @Prototype UpperBound get_proto() {
    return proto;
  }

  /** returns whether or not this invariant is enabled */
  @Override
  public boolean enabled() {
    return dkconfig_enabled;
  }

  /** UpperBound is only valid on integral types. */
  @Override
  public boolean instantiate_ok(VarInfo[] vis) {

    if (!valid_types(vis)) {
      return false;
    }

    return vis[0].file_rep_type.baseIsIntegral();
    }

  /** instantiate an invariant on the specified slice */
  @Override
  public UpperBound instantiate_dyn(@Prototype UpperBound this, PptSlice slice) {
    return new UpperBound(slice);
  }

  @SideEffectFree
  @Override
  public UpperBound clone(@GuardSatisfied UpperBound this) {
    UpperBound result = (UpperBound) super.clone();
    result.core = core.clone();
    result.core.wrapper = result;
    return result;
  }

  public long max() {
    return core.max();          // i.e., core.max1
  }

  @Override
  public String repr(@GuardSatisfied UpperBound this) {
    return "UpperBound" + varNames() + ": "
      + core.repr();
  }

  @SideEffectFree
  @Override
  public String format_using(@GuardSatisfied UpperBound this, OutputFormat format) {
    String name = var().name_using(format);
    PptTopLevel pptt = ppt.parent;

    if ((format == OutputFormat.DAIKON)
        || (format == OutputFormat.ESCJAVA)
        || format.isJavaFamily()
        || (format == OutputFormat.CSHARPCONTRACT)) {

      if (PrintInvariants.dkconfig_static_const_infer) {
        for (VarInfo vi : pptt.var_infos) {
          // Check is static constant, and variables are comparable
          if (vi.isStaticConstant() && VarComparability.comparable(vi, var())) {
            // If variable is a double, then use fuzzy comparison
            if (vi.rep_type == ProglangType.DOUBLE) {
              Double constantVal = (Double)vi.constantValue();
              if (Global.fuzzy.eq(constantVal, (double)(core.max1)) || false) {
                return name + " <= " + vi.name();
              }
            }
            // Otherwise just use the equals method
            else {
              Object constantVal = vi.constantValue();
              if (constantVal.equals(core.max1)) {
                return name + " <= " + vi.name();
              }
            }
          }
        }
      }

      return name + " <= " + core.max1;
    }

    if (format == OutputFormat.SIMPLIFY) {

      return "(<= " + name + " " + simplify_format_long(core.max1) + ")";
    }

    return format_unimplemented(format);
  }

  @Override
  public InvariantStatus add_modified(long value, int count) {
    // System.out.println("UpperBound" + varNames() + ": "
    //              + "add(" + value + ", " + modified + ", " + count + ")");

    return core.add_modified(value, count);

  }

  @Override
  public InvariantStatus check_modified(long value, int count) {

    return core.check(value);

  }

  @Override
  public boolean enoughSamples(@GuardSatisfied UpperBound this) {
    return core.enoughSamples();
  }

  @Override
  protected double computeConfidence() {
    return core.computeConfidence();
  }

  @Pure
  @Override
  public boolean isExact() {
    return core.isExact();
  }

  @Pure
  @Override
  public boolean isSameFormula(Invariant other) {
    return core.isSameFormula(((UpperBound) other).core);
  }

  @Override
  public boolean hasUninterestingConstant() {
    // If the constant bound is not in some small range of interesting
    // values (by default {-1, 0, 1, 2}), call it uninteresting.
    if ((core.max1 < dkconfig_minimal_interesting)
        || (core.max1 > dkconfig_maximal_interesting)) {
      return true;
    }

    return false;
  }

  @Pure
  @Override
  public @Nullable DiscardInfo isObviousStatically(VarInfo[] vis) {
    VarInfo var = vis[0];
    if ((var.derived instanceof SequenceLength)
         && (((SequenceLength) var.derived).shift != 0)) {
      return new DiscardInfo(this, DiscardCode.obvious, "Bounds are preferrable over sequence lengths with no shift");
    }

    if (var.aux.hasValue(VarInfoAux.MAXIMUM_VALUE)) {
      int minVal = var.aux.getInt(VarInfoAux.MAXIMUM_VALUE);
      if (minVal == core.max1) {
        return new DiscardInfo(this, DiscardCode.obvious,
          var.name() + " GTE " + core.max1 + " is already known");
      }
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

    PptTopLevel pptt = ppt.parent;

    // This check always lets invariants pass through (even if it is not within
    // the default range of (-1 to 2) if it matches a static constant
    // As noted below, this check really doesn't belong here, but should be
    // moved to hasUninterestingConstant() whenever that is implemented
    if (PrintInvariants.dkconfig_static_const_infer) {
      if (core.matchConstant()) {
        return null;
      }
    }

    // if the value is not in some range (like -1,0,1,2) then say that it is obvious
    if ((core.max1 < dkconfig_minimal_interesting)
        || (core.max1 > dkconfig_maximal_interesting)) {
      // XXX This check doesn't really belong here. However It
      // shouldn't get removed until hasUninterestingConstant() is
      // suitable to be turned on everywhere by default. -SMcC
      // if the value is not in some range (like -1,0,1,2) then say that
      // it is obvious
      String discardString = "";
      if (core.max1 < dkconfig_minimal_interesting) {
        discardString = "MIN1="+core.max1+" is less than dkconfig_minimal_interesting=="
          + dkconfig_minimal_interesting;
      } else {
        discardString = "MIN1="+core.max1+" is greater than dkconfig_maximal_interesting=="+
          dkconfig_maximal_interesting;
      }
      return new DiscardInfo(this, DiscardCode.obvious, discardString);
    }
    OneOfScalar oo = OneOfScalar.find(ppt);
    if ((oo != null) && oo.enoughSamples() && oo.num_elts() > 0) {
      assert oo.var().isCanonical();
      // We could also use core.max1 == oo.max_elt(), since the LowerBound
      // will never have a core.max1 that does not appear in the OneOf.
      if (core.max1 >= oo.max_elt()) {
        String varName = vis[0].name();
        String discardString = varName + ">=" + core.max1 + " is implied by " + varName + ">=" + oo.max_elt();
        log("%s", discardString);
        return new DiscardInfo(this, DiscardCode.obvious, discardString);
      }
    }

    // NOT: "VarInfo v = var();" because we want to operate not on this
    // object's own variables, but on the variables that were passed in.
    VarInfo v = vis[0];

    // For each sequence variable, if this is an obvious member/subsequence, and
    // it has the same invariant, then this one is obvious.
    for (int i = 0; i < pptt.var_infos.length; i++) {
      VarInfo vi = pptt.var_infos[i];

      if (Member.isObviousMember(v, vi))
      {
        PptSlice1 other_slice = pptt.findSlice(vi);
        if (other_slice != null) {
          EltUpperBound eb = EltUpperBound.find(other_slice);
          if ((eb != null)
              && eb.enoughSamples()
              && eb.max() == max()) {
            String otherName = other_slice.var_infos[0].name();
            String varName = v.name();
            String discardString = varName+" is a subsequence of "+otherName+" for which the invariant holds.";
            log("%s", discardString);
            return new DiscardInfo(this, DiscardCode.obvious, discardString);
          }
        }
      }
    }

    return null;
  }

  @Pure
  @Override
  public boolean isExclusiveFormula(Invariant other) {

    if (other instanceof LowerBound) {
      if (max() < ((LowerBound) other).min()) {
        return true;
      }
    }

    if (other instanceof OneOfScalar) {
      return other.isExclusiveFormula(this);
    }
    return false;
  }

  // Look up a previously instantiated invariant.
  public static @Nullable UpperBound find(PptSlice ppt) {
    assert ppt.arity() == 1;
    for (Invariant inv : ppt.invs) {
      if (inv instanceof UpperBound) {
        return (UpperBound) inv;
      }
    }
    return null;
  }

  /**
   * Bound can merge different formulas from lower points to create a single formula at an upper
   * point. See merge() below.
   */
  @Override
  public boolean mergeFormulasOk() {
    return true;
  }

  /**
   * Merge the invariants in invs to form a new invariant. Each must be a UpperBound invariant. This
   * code finds all of the min/max values in each invariant, applies them to a new parent invariant
   * and returns the merged invariant (if any).
   *
   * @param invs list of invariants to merge. The invariants must all be of the same type and should
   *     come from the children of parent_ppt. They should also all be permuted to match the
   *     variable order in parent_ppt.
   * @param parent_ppt slice that will contain the new invariant
   */
  @Override
  public @Nullable Invariant merge(List<Invariant> invs, PptSlice parent_ppt) {

    // Create the initial parent invariant from the first child
    UpperBound first = (UpperBound) invs.get(0);
    UpperBound result= first.clone();
    result.ppt = parent_ppt;

    // Loop through the rest of the child invariants
    for (int i = 1; i < invs.size(); i++ ) {
      UpperBound lb = (UpperBound) invs.get(i);
      result.core.add(lb.core);
    }

    result.log("Merged '%s' from %s child invariants", result.format(),invs.size());
    return result;
  }
}
