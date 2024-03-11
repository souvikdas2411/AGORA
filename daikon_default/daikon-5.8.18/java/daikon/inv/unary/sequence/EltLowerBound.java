// ***** This file is automatically generated from Bound.java.jpp

package daikon.inv.unary.sequence;

import daikon.*;
import daikon.inv.*;

  import daikon.inv.binary.twoSequence.*;
  import daikon.inv.unary.scalar.*;

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
   * Represents the invariant that each element of a sequence of long values is greater than or
   * equal to a constant. Prints as {@code x[] elements >= c}.
   */

// One reason not to combine LowerBound and UpperBound into a single range
// invariant is that they have separate justifications:  one may be
// justified when the other is not.
@SuppressWarnings("UnnecessaryParentheses")  // code generated by macros
public class EltLowerBound extends SingleScalarSequence {
  // We are Serializable, so we specify a version to allow changes to
  // method signatures without breaking serialization.  If you add or
  // remove fields, you should change this number to the current date.
  static final long serialVersionUID = 20030822L;

  // Variables starting with dkconfig_ should only be set via the
  // daikon.config.Configuration interface.
  /** Boolean. True iff EltLowerBound invariants should be considered. */
  public static boolean dkconfig_enabled = Invariant.invariantEnabledDefault;
  /**
   * Long integer. Together with the corresponding {@code maximal_interesting} parameter,
   * specifies the range of the computed constant that is ``interesting'' --- the range that should
   * be reported. For instance, setting {@code minimal_interesting} to -1 and
   * {@code maximal_interesting} to 2 would only permit output of EltLowerBound invariants whose
   * cutoff was one of (-1,0,1,2).
   */
  public static long dkconfig_minimal_interesting = -1;
  /**
   * Long integer. Together with the corresponding {@code minimal_interesting} parameter,
   * specifies the range of the computed constant that is ``interesting'' --- the range that should
   * be reported. For instance, setting {@code minimal_interesting} to -1 and
   * {@code maximal_interesting} to 2 would only permit output of EltLowerBound invariants whose
   * cutoff was one of (-1,0,1,2).
   */
  public static long dkconfig_maximal_interesting = 2;

  @Unused(when=Prototype.class)
  private LowerBoundCore core;

  @SuppressWarnings("nullness") // circular initialization
  private EltLowerBound(PptSlice slice) {
    super(slice);
    assert slice != null;
    core = new LowerBoundCore(this);
  }

  private @Prototype EltLowerBound() {
    super();
    // do we need a core?
  }

  private static @Prototype EltLowerBound proto = new @Prototype EltLowerBound();

  /** Returns the prototype invariant for EltLowerBound */
  public static @Prototype EltLowerBound get_proto() {
    return proto;
  }

  /** returns whether or not this invariant is enabled */
  @Override
  public boolean enabled() {
    return dkconfig_enabled;
  }

  /** EltLowerBound is only valid on integral types. */
  @Override
  public boolean instantiate_ok(VarInfo[] vis) {

    if (!valid_types(vis)) {
      return false;
    }

    return vis[0].file_rep_type.baseIsIntegral();
    }

  /** instantiate an invariant on the specified slice */
  @Override
  public EltLowerBound instantiate_dyn(@Prototype EltLowerBound this, PptSlice slice) {
    return new EltLowerBound(slice);
  }

  @SideEffectFree
  @Override
  public EltLowerBound clone(@GuardSatisfied EltLowerBound this) {
    EltLowerBound result = (EltLowerBound) super.clone();
    result.core = core.clone();
    result.core.wrapper = result;
    return result;
  }

  public long min() {
    return core.min();          // i.e., core.min1
  }

  @Override
  public String repr(@GuardSatisfied EltLowerBound this) {
    return "EltLowerBound" + varNames() + ": "
      + core.repr();
  }

  @SideEffectFree
  @Override
  public String format_using(@GuardSatisfied EltLowerBound this, OutputFormat format) {

    if (format.isJavaFamily()) {
      return format_java_family(format);
    }

    if (format == OutputFormat.DAIKON) {
      return format_daikon();
    } else if (format == OutputFormat.SIMPLIFY) {
      return format_simplify();
    } else if (format == OutputFormat.ESCJAVA) {
      return format_esc();
    } else if (format == OutputFormat.CSHARPCONTRACT) {
      return format_csharp_contract();
    }

    return format_unimplemented(format);
  }
  // ELTLOWEr || ELTUPPEr
  public String format_daikon(@GuardSatisfied EltLowerBound this) {
    PptTopLevel pptt = ppt.parent;
    String name = var().name();

    if (PrintInvariants.dkconfig_static_const_infer) {
      for (VarInfo vi : pptt.var_infos) {
        if (vi.isStaticConstant() && VarComparability.comparable(vi, var())) {
          // If variable is a double, then use fuzzy comparison
          if (vi.rep_type == ProglangType.DOUBLE) {
            Double constantVal = (Double)vi.constantValue();
            if (Global.fuzzy.eq(constantVal, (double)(core.min1)) || false) {
              return name + " >= " + vi.name();
            }
          }
          // Otherwise just use the equals method
          else {
            Object constantVal = vi.constantValue();
            if (constantVal.equals(core.min1)) {
              return name + " >= " + vi.name();
            }
          }
        }
      }
    }

    return var().name() + " elements >= " + core.min1;
  }

  public String format_esc(@GuardSatisfied EltLowerBound this) {
    PptTopLevel pptt = ppt.parent;

    if (PrintInvariants.dkconfig_static_const_infer) {
      for (VarInfo vi : pptt.var_infos) {
        if (vi.isStaticConstant() && VarComparability.comparable(vi, var())) {
          // If variable is a double, then use fuzzy comparison
          if (vi.rep_type == ProglangType.DOUBLE) {
            Double constantVal = (Double)vi.constantValue();
            if (Global.fuzzy.eq(constantVal, (double)(core.min1)) || false) {

              String[] form = VarInfo.esc_quantify(var());
              return form[0] + "(" + form[1] + " >= " + vi.name() + ")" + form[2];
            }
          }
          // Otherwise just use the equals method
            else {
            Object constantVal = vi.constantValue();
            if (constantVal.equals(core.min1)) {

              String[] form = VarInfo.esc_quantify(var());
              return form[0] + "(" + form[1] + " >= " + vi.name() + ")" + form[2];
            }
          }
        }
      }
    }

    String[] form = VarInfo.esc_quantify(var());
    return form[0] + "(" + form[1] + " >= " + core.min1 + ")" + form[2];
  }

  public String format_csharp_contract(@GuardSatisfied EltLowerBound this) {
    PptTopLevel pptt = ppt.parent;

    if (PrintInvariants.dkconfig_static_const_infer) {
      for (VarInfo vi : pptt.var_infos) {
        if (vi.isStaticConstant() && VarComparability.comparable(vi, var())) {
          // If variable is a double, then use fuzzy comparison
          if (vi.rep_type == ProglangType.DOUBLE) {
            Double constantVal = (Double)vi.constantValue();
            if (Global.fuzzy.eq(constantVal, (double)(core.min1)) || false) {

              String[] split = var().csharp_array_split();
              return "Contract.ForAll(" + split[0] + ", x => x" + split[1] + " >= " + vi.name() + ")";
            }
          }
          // Otherwise just use the equals method
          else {
            Object constantVal = vi.constantValue();
            if (constantVal.equals(core.min1)) {

              String[] split = var().csharp_array_split();
              return "Contract.ForAll(" + split[0] + ", x => x" + split[1] + " >= " + vi.name() + ")";
            }
          }
        }
      }
    }

    String[] split = var().csharp_array_split();
    return "Contract.ForAll(" + split[0] + ", x => x" + split[1] + " >= " + core.min1+ ")";
  }

  public String format_java_family(@GuardSatisfied EltLowerBound this, OutputFormat format) {
    PptTopLevel pptt = ppt.parent;

    if (PrintInvariants.dkconfig_static_const_infer) {
      for (VarInfo vi : pptt.var_infos) {
        if (vi.isStaticConstant() && VarComparability.comparable(vi, var())) {
          // If variable is a double, then use fuzzy comparison
          if (vi.rep_type == ProglangType.DOUBLE) {
            Double constantVal = (Double)vi.constantValue();
            if (Global.fuzzy.eq(constantVal, (double)(core.min1)) || false) {

              return "daikon.Quant.eltsGTE(" + var().name_using(format) + ", " + vi.name() + ")";
            }
          }
          // Otherwise just use the equals method
          else {
            Object constantVal = vi.constantValue();
            if (constantVal.equals(core.min1)) {

              return "daikon.Quant.eltsGTE(" + var().name_using(format) + ", " + vi.name() + ")";
            }
          }
        }
      }
    }

    return
      "daikon.Quant.eltsGTE(" + var().name_using(format) + ", " + core.min1 + ")";

  }

  public String format_simplify(@GuardSatisfied EltLowerBound this) {

    String value = simplify_format_long(core.min1);

    String[] form = VarInfo.simplify_quantify(var());
    return form[0] + "(>= " + form[1] + " " + value + ")"
      + form[2];

  }

  @Override
  public InvariantStatus add_modified(long @Interned [] value, int count) {
    // System.out.println("EltLowerBound" + varNames() + ": "
    //              + "add(" + value + ", " + modified + ", " + count + ")");

    boolean changed = false;
    InvariantStatus status = InvariantStatus.NO_CHANGE;
    for (int i = 0; i < value.length; i++) {
      if (!changed && core.wouldChange(value[i])) {
        changed = true;
        status = InvariantStatus.WEAKENED;
      }
      if (core.add_modified(value[i], count) ==
          InvariantStatus.FALSIFIED) {
        return InvariantStatus.FALSIFIED;
      }
    }
    return status;
  }

  @Override
  public InvariantStatus check_modified(long @Interned [] value, int count) {

    for (int i = 0; i < value.length; i++) {
      if (core.check(value[i]) == InvariantStatus.WEAKENED) {
        return InvariantStatus.WEAKENED;
      }
    }
    return InvariantStatus.NO_CHANGE;
  }

  @Override
  public boolean enoughSamples(@GuardSatisfied EltLowerBound this) {
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
    return core.isSameFormula(((EltLowerBound) other).core);
  }

  @Override
  public boolean hasUninterestingConstant() {
    // If the constant bound is not in some small range of interesting
    // values (by default {-1, 0, 1, 2}), call it uninteresting.
    if ((core.min1 < dkconfig_minimal_interesting)
        || (core.min1 > dkconfig_maximal_interesting)) {
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
    if ((core.min1 < dkconfig_minimal_interesting)
        || (core.min1 > dkconfig_maximal_interesting)) {
      // XXX This check doesn't really belong here. However It
      // shouldn't get removed until hasUninterestingConstant() is
      // suitable to be turned on everywhere by default. -SMcC
      // if the value is not in some range (like -1,0,1,2) then say that
      // it is obvious
      String discardString = "";
      if (core.min1 < dkconfig_minimal_interesting) {
        discardString = "MIN1="+core.min1+" is less than dkconfig_minimal_interesting=="
          + dkconfig_minimal_interesting;
      } else {
        discardString = "MIN1="+core.min1+" is greater than dkconfig_maximal_interesting=="+
          dkconfig_maximal_interesting;
      }
      return new DiscardInfo(this, DiscardCode.obvious, discardString);
    }
    EltOneOf oo = EltOneOf.find(ppt);
    if ((oo != null) && oo.enoughSamples() && oo.num_elts() > 0) {
      assert oo.var().isCanonical();
      // We could also use core.min1 == oo.min_elt(), since the LowerBound
      // will never have a core.min1 that does not appear in the OneOf.
      if (core.min1 <= oo.min_elt()) {
        String varName = vis[0].name();
        String discardString = varName + "<=" + core.min1 + " is implied by " + varName + "<=" + oo.min_elt();
        log("%s", discardString);
        return new DiscardInfo(this, DiscardCode.obvious, discardString);
      }
    }

    // NOT: "VarInfo v = var();" because we want to operate not on this
    // object's own variables, but on the variables that were passed in.
    VarInfo v = vis[0];

    // Look for the same property over a supersequence of this one.
    for (Iterator<Invariant> inv_itor = pptt.invariants_iterator(); inv_itor.hasNext(); ) {
      Invariant inv = inv_itor.next();
      if (inv == this) {
        continue;
      }
      if (inv instanceof EltLowerBound) {
        EltLowerBound other = (EltLowerBound) inv;
        if (isSameFormula(other)
            && SubSequence.isObviousSubSequenceDynamically(this, v, other.var())) {
          String varName = v.name();
          String otherName = other.var().name();
          String discardString = varName + " is a subsequence of " + otherName + " for which the invariant holds.";
          log("%s", discardString);
          return new DiscardInfo(this, DiscardCode.obvious, discardString);
        }
      }
    }

    // For each sequence variable, if this is an obvious member/subsequence, and
    // it has the same invariant, then this one is obvious.
    for (int i = 0; i < pptt.var_infos.length; i++) {
      VarInfo vi = pptt.var_infos[i];

      if (SubSequence.isObviousSubSequenceDynamically(this, v, vi))
      {
        PptSlice1 other_slice = pptt.findSlice(vi);
        if (other_slice != null) {
          EltLowerBound eb = EltLowerBound.find(other_slice);
          if ((eb != null)
              && eb.enoughSamples()
              && eb.min() == min()) {
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

    // N.B. "x[] elements >= 200" is not mutually exclusive with "x[]
    // elements <= 100"; they could both be true if x[] were always empty.

    if (other instanceof OneOfScalar) {
      return other.isExclusiveFormula(this);
    }
    return false;
  }

  // Look up a previously instantiated invariant.
  public static @Nullable EltLowerBound find(PptSlice ppt) {
    assert ppt.arity() == 1;
    for (Invariant inv : ppt.invs) {
      if (inv instanceof EltLowerBound) {
        return (EltLowerBound) inv;
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
   * Merge the invariants in invs to form a new invariant. Each must be a EltLowerBound invariant. This
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
    EltLowerBound first = (EltLowerBound) invs.get(0);
    EltLowerBound result= first.clone();
    result.ppt = parent_ppt;

    // Loop through the rest of the child invariants
    for (int i = 1; i < invs.size(); i++ ) {
      EltLowerBound lb = (EltLowerBound) invs.get(i);
      result.core.add(lb.core);
    }

    result.log("Merged '%s' from %s child invariants", result.format(),invs.size());
    return result;
  }
}