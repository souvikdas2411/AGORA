// ***** This file is automatically generated from SequenceInitial.java.jpp

package daikon.derive.unary;

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.checker.interning.qual.Interned;
import daikon.*;
import daikon.derive.*;
import daikon.derive.binary.*;
import org.plumelib.util.Intern;

// originally from pass1.
/**
 * This represents a sequence element at a particular offset (such as first, second, penultimate,
 * last).
 */
public final class SequenceInitial extends UnaryDerivation {
  // We are Serializable, so we specify a version to allow changes to
  // method signatures without breaking serialization.  If you add or
  // remove fields, you should change this number to the current date.
  static final long serialVersionUID = 20020122L;

  // Variables starting with dkconfig_ should only be set via the
  // daikon.config.Configuration interface.
  /** Boolean. True iff SequenceInitial derived variables should be generated. */
  public static boolean dkconfig_enabled = false;

  /** Typically 0, 1, -1, or -2. A negative number means counting from end. */
  public final int index;

  /** Array length required for the subscript to be meaningful:  (i.e., 1 or 2) */
  final int minLength;

  SequenceInitial(VarInfo vi, int index) {
    super(vi);
    this.index = index;
    if (index < 0) {
      minLength = -index;
    } else {
      minLength = index + 1;
    }
  }

  public VarInfo seqvar() {
    return base;
  }

  public static boolean applicable(VarInfo vi) {
    assert vi.rep_type == ProglangType.INT_ARRAY;
    // For now, applicable if not a derived variable; a better test is if
    // not a prefix subsequence (sequence slice) we have added.
    if (vi.derived != null) {
      assert (vi.derived instanceof SequenceScalarSubsequence)
          || (vi.derived instanceof SequenceScalarIntersection)
          || (vi.derived instanceof SequenceScalarUnion);
      return false;
    }

    // If order doesn't matter
    if (!vi.aux.hasOrder()) {
      return false;
    }

    return true;
  }

  @Override
  public ValueAndModified computeValueAndModifiedImpl(ValueTuple vt) {
    int source_mod = base.getModified(vt);
    if (source_mod == ValueTuple.MISSING_NONSENSICAL) {
      return ValueAndModified.MISSING_NONSENSICAL;
    }
    Object val = base.getValue(vt);
    if (val == null) {
      return ValueAndModified.MISSING_NONSENSICAL;
    }
    if (base.rep_type == ProglangType.INT_ARRAY) {
      long[] val_array = (long[]) val;
      if (val_array.length < minLength) {
        return ValueAndModified.MISSING_NONSENSICAL;
      }
      int real_index = (index < 0 ? val_array.length + index : index);
      return new ValueAndModified(Intern.internedLong(val_array[real_index]), source_mod);
    } else {
      @Interned Object[] val_array = (@Interned Object[]) val;
      if (val_array.length < minLength) {
        return ValueAndModified.MISSING_NONSENSICAL;
      }
      int real_index = (index < 0 ? val_array.length + index : index);
      return new ValueAndModified(val_array[real_index], source_mod);
    }
  }

  @Override
  protected VarInfo makeVarInfo() {
    return VarInfo.make_subscript(base, null, index);
  }

  @Pure
  @Override
  public boolean isSameFormula(Derivation other) {
    return (other instanceof SequenceInitial)
      && (((SequenceInitial) other).index == this.index);
  }

  /** Returns the ESC name. */
  @SideEffectFree
  @Override
  public String esc_name(String index) {
    return String.format("%s[0]", base.esc_name());
  }
}
