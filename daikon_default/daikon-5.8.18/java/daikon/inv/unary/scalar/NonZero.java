// ***** This file is automatically generated from NonZero.java.jpp

package daikon.inv.unary.scalar;

import daikon.*;
import daikon.derive.unary.*;
import daikon.inv.*;
import daikon.inv.binary.sequenceScalar.*;
import daikon.inv.unary.sequence.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.lock.qual.GuardSatisfied;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.plumelib.util.Intern;
import typequals.prototype.qual.NonPrototype;
import typequals.prototype.qual.Prototype;

// This also serves as NonNull.

/**
 * Represents long scalars that are non-zero. Prints as {@code x != 0}, or as {@code x !=
 * null} for pointer types.
 */

public class NonZero extends SingleScalar {
  // We are Serializable, so we specify a version to allow changes to
  // method signatures without breaking serialization.  If you add or
  // remove fields, you should change this number to the current date.
  static final long serialVersionUID = 20030822L;

  // Variables starting with dkconfig_ should only be set via the
  // daikon.config.Configuration interface.
  /** Boolean. True iff NonZero invariants should be considered. */
  public static boolean dkconfig_enabled = Invariant.invariantEnabledDefault;

  /** Debug tracer. */
  public static final Logger debug = Logger.getLogger("daikon.inv.unary.scalar.NonZero");

  /** Maximum value ever used for max-min in confidence calculation. */
  static long range_max = 50;

  private NonZero(PptSlice ppt) {
    super(ppt);
  }

  private @Prototype NonZero() {
    super();
  }

  private static @Prototype NonZero proto = new @Prototype NonZero();

  /** Returns the prototype invariant for NonZero */
  public static @Prototype NonZero get_proto() {
    return proto;
  }

  /** returns whether or not this invariant is enabled */
  @Override
  public boolean enabled() {
    return dkconfig_enabled;
  }

  /** Make sure the NonZero make sense on these vars. */
  @Override
  public boolean instantiate_ok(VarInfo[] vis) {

    if (!valid_types(vis)) {
      return false;
    }

    if (vis[0].aux.isStruct()
        || vis[0].aux.isNonNull()
        || !vis[0].aux.hasNull())
      return false;

    return true;
  }

  /** instantiate an invariant on the specified slice */
  @Override
  public NonZero instantiate_dyn(@Prototype NonZero this, PptSlice slice) {
    return new NonZero(slice);
  }

  private String zero(@GuardSatisfied @Prototype NonZero this, @SuppressWarnings("UnusedVariable") OutputFormat format) {

    if (is_pointer()) {
      return "null";
    } else {
      return "0";
    }

  }

  @SideEffectFree
  @Override
  public String format_using(@GuardSatisfied @Prototype NonZero this, OutputFormat format) {
    // // var() fails for prototype invariants
    // if (ppt == null) {
    //   return "Prototype NonZero invariant (ppt == null)";
    // }

    String name = var().name_using(format);

    if (format.isJavaFamily()) {

        return name + " != " + zero(format);
    }

    if ((format == OutputFormat.DAIKON)
        || (format == OutputFormat.ESCJAVA)
        || (format == OutputFormat.CSHARPCONTRACT)) {
      return name + " != " + zero(format);
    }

    if (format == OutputFormat.SIMPLIFY) {
      return "(NEQ " + var().simplifyFixup(name) + " " + zero(format) + ")";
    }

    return format_unimplemented(format);
  }

  @Override
  public InvariantStatus check_modified(long v, int count) {
    if (v == 0) {
      return InvariantStatus.FALSIFIED;
    } else {
      return InvariantStatus.NO_CHANGE;
    }
  }

  @Override
  public InvariantStatus add_modified(long v, int count) {
    InvariantStatus status = check_modified(v, count);
    if (status == InvariantStatus.FALSIFIED) {
      if (logOn()) {
        log(debug, "falsified (value = " + v + ")");
      }
    } // else if (logDetail())
      // log ("add_modified (" + v + ")");
    return status;
  }

  /** Returns whether or not the variable is a pointer. */
  @Pure
  private boolean is_pointer(@GuardSatisfied NonZero this) {
    return ppt.var_infos[0].file_rep_type == ProglangType.HASHCODE;
  }

  @Override
  protected double computeConfidence() {
    return 1 - computeProbability();
  }

  // used by computeConfidence
  protected double computeProbability() {
    assert ! falsified;
    // This method works by looking at all sample values and
    // calculating the probability that they were all non-zero by
    // chance (assuming a uniform distribution).  If the variable is
    // not a pointer, the range used is the observed range from sample
    // data.  Further observed constraints are used to change the
    // returned probability, such as all samples being congruent some
    // modulus.

    ValueSet.ValueSetScalar vs = (ValueSet.ValueSetScalar) ppt.var_infos[0].get_value_set();

    // If greater than or less than 0, the bounds invariant will be more
    // interesting
    if (!is_pointer() && ((vs.min() > 0) || (vs.max() < 0))) {

      // Maybe just use 0 as the min or max instead, and see what happens:
      // see whether the "nonzero" invariant holds anyway.  (Perhaps only
      // makes sense to do if the {Lower,Upper}Bound invariant doesn't imply
      // the non-zeroness.)  In that case, do still check for no values yet
      // received.
      return Invariant.PROBABILITY_UNJUSTIFIED;
    } else {
      long range;
      if (is_pointer()) {
        range = 3;
      } else {
        long modulus = 1;
        {
          Modulus mi = Modulus.find(ppt);
          if (mi != null) {
            modulus = mi.modulus;
          }
        }
        // Perhaps I ought to check that it's possible (given the modulus
        // constraints) for the value to be zero; otherwise, the modulus
        // constraint implies non-zero.
        range = (vs.max() - vs.min() + 1) / modulus;
      }
      if ((range_max != 0) && (range > range_max)) {
        range = range_max;
      }

      double probability_one_elt_nonzero = 1 - 1.0/range;
      // This could underflow; so consider doing
      //   double log_probability = self.samples*math.log(probability);
      // then calling Math.exp (if the value is in the range that wouldn't
      // cause underflow).
      // return Math.pow(probability_one_elt_nonzero, ppt.num_mod_samples());
      return Math.pow(probability_one_elt_nonzero, ppt.num_samples());
    }
  }

  @Pure
  @Override
  public @Nullable DiscardInfo isObviousStatically(VarInfo[] vis) {
    VarInfo var = vis[0];

    if (var.aux.isStruct()) {
      return new DiscardInfo(this, DiscardCode.obvious,
                             var.name() + " is a struct");
    }

    if (var.aux.isNonNull()) {
      return new DiscardInfo(this, DiscardCode.obvious,
                             "aux information says " + var.name() + " is non-null");
    }

    if (!var.aux.hasNull()) {
      return new DiscardInfo(this, DiscardCode.obvious,
                     "'null' has no special meaning for " + var.name());
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

    VarInfo var = vis[0];

    Debug dlog = new Debug(getClass(), ppt, vis);

    if (logOn()) {
      dlog.log("Checking IsObviousDynamically");
    }

    // System.out.println("isObviousImplied: " + format());

    // For every EltNonZero at this program point, see if this variable is
    // an obvious member of that sequence.
    PptTopLevel parent = ppt.parent;
    for (Iterator<Invariant> itor = parent.invariants_iterator(); itor.hasNext(); ) {
      Invariant inv = itor.next();
      if ((inv instanceof EltNonZero) && inv.enoughSamples()) {
        VarInfo v2 = inv.ppt.var_infos[0];
        // System.out.println("NonZero.isObviousImplied: calling Member.isObviousMember(" + var.name + ", " + v2.name + ")");
        // Don't use isEqualToObviousMember:  that is too subtle
        // and eliminates desirable invariants such as "return != null".
        if (Member.isObviousMember(var, v2)) {
          // System.out.println("NonZero.isObviousImplied: Member.isObviousMember(" + var.name + ", " + v2.name + ") = true");
          if (logOn()) {
            dlog.log("isObvDyn- true, arg is member of nonzero sequence");
          }
          String discardString = var.name() + " is a member of the non-zero sequence " + v2.name();
          if (logOn()) {
            log("%s obviously implied from %s", format(), inv.format());
          }
          return new DiscardInfo(this, DiscardCode.obvious, discardString);
        }
      }
    }

    if ((var.derived != null)
        && (var.derived instanceof SequenceInitial)) {
      SequenceInitial si = (SequenceInitial) var.derived;
      if (si.index == 0) {

        // For each sequence variable, if var is an obvious member, and
        // the sequence has the same invariant, then this one is obvious.
        PptTopLevel pptt = ppt.parent;
        for (int i = 0; i < pptt.var_infos.length; i++) {
          VarInfo vi = pptt.var_infos[i];
          if (Member.isObviousMember(var, vi)) {
            PptSlice1 other_slice = pptt.findSlice(vi);
            if (other_slice != null) {
              SeqIndexIntNonEqual sine = SeqIndexIntNonEqual.find(other_slice);
              if ((sine != null) && sine.enoughSamples()) {
                // System.out.println("NonZero.isObviousImplied true due to: " + sine.format());
                if (logOn()) {
                  dlog.log("isObvDyn- true due to " + sine.format());
                }
                String discardString = var.name() + " is a member of the non-zero sequence " + vi.name();
                return new DiscardInfo(this, DiscardCode.obvious, discardString);
              }
            }
          }
        }
      }
    }

    return null;
  }

  @Pure
  @Override
  public boolean isSameFormula(Invariant other) {
    assert other instanceof NonZero;
    return true;
  }

  @Pure
  @Override
  public boolean isExclusiveFormula(Invariant other) {
    if (other instanceof OneOfScalar) {
      OneOfScalar oos = (OneOfScalar) other;
      if ((oos.num_elts() == 1) && (((Long)oos.elt()).longValue() == 0)) {
        return true;
      }
    }
    return false;
  }
}
