/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.alone.thrift.struct;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-08-04")
public class InstallActiveStruct implements org.apache.thrift.TBase<InstallActiveStruct, InstallActiveStruct._Fields>, java.io.Serializable, Cloneable, Comparable<InstallActiveStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InstallActiveStruct");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MEMO_FIELD_DESC = new org.apache.thrift.protocol.TField("memo", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField HOURS_FIELD_DESC = new org.apache.thrift.protocol.TField("hours", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new InstallActiveStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new InstallActiveStructTupleSchemeFactory());
  }

  private long id; // required
  private String name; // required
  private String memo; // required
  private int hours; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    NAME((short)2, "name"),
    MEMO((short)3, "memo"),
    HOURS((short)4, "hours");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // NAME
          return NAME;
        case 3: // MEMO
          return MEMO;
        case 4: // HOURS
          return HOURS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __HOURS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MEMO, new org.apache.thrift.meta_data.FieldMetaData("memo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOURS, new org.apache.thrift.meta_data.FieldMetaData("hours", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InstallActiveStruct.class, metaDataMap);
  }

  public InstallActiveStruct() {
  }

  public InstallActiveStruct(
    long id,
    String name,
    String memo,
    int hours)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.name = name;
    this.memo = memo;
    this.hours = hours;
    setHoursIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public InstallActiveStruct(InstallActiveStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetMemo()) {
      this.memo = other.memo;
    }
    this.hours = other.hours;
  }

  public InstallActiveStruct deepCopy() {
    return new InstallActiveStruct(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.name = null;
    this.memo = null;
    setHoursIsSet(false);
    this.hours = 0;
  }

  public long getId() {
    return this.id;
  }

  public InstallActiveStruct setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public InstallActiveStruct setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getMemo() {
    return this.memo;
  }

  public InstallActiveStruct setMemo(String memo) {
    this.memo = memo;
    return this;
  }

  public void unsetMemo() {
    this.memo = null;
  }

  /** Returns true if field memo is set (has been assigned a value) and false otherwise */
  public boolean isSetMemo() {
    return this.memo != null;
  }

  public void setMemoIsSet(boolean value) {
    if (!value) {
      this.memo = null;
    }
  }

  public int getHours() {
    return this.hours;
  }

  public InstallActiveStruct setHours(int hours) {
    this.hours = hours;
    setHoursIsSet(true);
    return this;
  }

  public void unsetHours() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HOURS_ISSET_ID);
  }

  /** Returns true if field hours is set (has been assigned a value) and false otherwise */
  public boolean isSetHours() {
    return EncodingUtils.testBit(__isset_bitfield, __HOURS_ISSET_ID);
  }

  public void setHoursIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HOURS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case MEMO:
      if (value == null) {
        unsetMemo();
      } else {
        setMemo((String)value);
      }
      break;

    case HOURS:
      if (value == null) {
        unsetHours();
      } else {
        setHours((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case NAME:
      return getName();

    case MEMO:
      return getMemo();

    case HOURS:
      return getHours();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case NAME:
      return isSetName();
    case MEMO:
      return isSetMemo();
    case HOURS:
      return isSetHours();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof InstallActiveStruct)
      return this.equals((InstallActiveStruct)that);
    return false;
  }

  public boolean equals(InstallActiveStruct that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_memo = true && this.isSetMemo();
    boolean that_present_memo = true && that.isSetMemo();
    if (this_present_memo || that_present_memo) {
      if (!(this_present_memo && that_present_memo))
        return false;
      if (!this.memo.equals(that.memo))
        return false;
    }

    boolean this_present_hours = true;
    boolean that_present_hours = true;
    if (this_present_hours || that_present_hours) {
      if (!(this_present_hours && that_present_hours))
        return false;
      if (this.hours != that.hours)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_memo = true && (isSetMemo());
    list.add(present_memo);
    if (present_memo)
      list.add(memo);

    boolean present_hours = true;
    list.add(present_hours);
    if (present_hours)
      list.add(hours);

    return list.hashCode();
  }

  @Override
  public int compareTo(InstallActiveStruct other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMemo()).compareTo(other.isSetMemo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memo, other.memo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHours()).compareTo(other.isSetHours());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHours()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hours, other.hours);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("InstallActiveStruct(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("memo:");
    if (this.memo == null) {
      sb.append("null");
    } else {
      sb.append(this.memo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hours:");
    sb.append(this.hours);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class InstallActiveStructStandardSchemeFactory implements SchemeFactory {
    public InstallActiveStructStandardScheme getScheme() {
      return new InstallActiveStructStandardScheme();
    }
  }

  private static class InstallActiveStructStandardScheme extends StandardScheme<InstallActiveStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, InstallActiveStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEMO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.memo = iprot.readString();
              struct.setMemoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HOURS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.hours = iprot.readI32();
              struct.setHoursIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, InstallActiveStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI64(struct.id);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.memo != null) {
        oprot.writeFieldBegin(MEMO_FIELD_DESC);
        oprot.writeString(struct.memo);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(HOURS_FIELD_DESC);
      oprot.writeI32(struct.hours);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class InstallActiveStructTupleSchemeFactory implements SchemeFactory {
    public InstallActiveStructTupleScheme getScheme() {
      return new InstallActiveStructTupleScheme();
    }
  }

  private static class InstallActiveStructTupleScheme extends TupleScheme<InstallActiveStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, InstallActiveStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetMemo()) {
        optionals.set(2);
      }
      if (struct.isSetHours()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetMemo()) {
        oprot.writeString(struct.memo);
      }
      if (struct.isSetHours()) {
        oprot.writeI32(struct.hours);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, InstallActiveStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.memo = iprot.readString();
        struct.setMemoIsSet(true);
      }
      if (incoming.get(3)) {
        struct.hours = iprot.readI32();
        struct.setHoursIsSet(true);
      }
    }
  }

}

