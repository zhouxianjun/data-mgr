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
public class BoxStruct implements org.apache.thrift.TBase<BoxStruct, BoxStruct._Fields>, java.io.Serializable, Cloneable, Comparable<BoxStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BoxStruct");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("user_id", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField BOX_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("box_id", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.BOOL, (short)4);
  private static final org.apache.thrift.protocol.TField PROVINCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("province_id", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField CITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("city_id", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BoxStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BoxStructTupleSchemeFactory());
  }

  private long id; // required
  private long user_id; // required
  private String box_id; // required
  private boolean status; // required
  private int province_id; // required
  private int city_id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    USER_ID((short)2, "user_id"),
    BOX_ID((short)3, "box_id"),
    STATUS((short)4, "status"),
    PROVINCE_ID((short)5, "province_id"),
    CITY_ID((short)6, "city_id");

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
        case 2: // USER_ID
          return USER_ID;
        case 3: // BOX_ID
          return BOX_ID;
        case 4: // STATUS
          return STATUS;
        case 5: // PROVINCE_ID
          return PROVINCE_ID;
        case 6: // CITY_ID
          return CITY_ID;
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
  private static final int __USER_ID_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private static final int __PROVINCE_ID_ISSET_ID = 3;
  private static final int __CITY_ID_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("user_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BOX_ID, new org.apache.thrift.meta_data.FieldMetaData("box_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.PROVINCE_ID, new org.apache.thrift.meta_data.FieldMetaData("province_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CITY_ID, new org.apache.thrift.meta_data.FieldMetaData("city_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BoxStruct.class, metaDataMap);
  }

  public BoxStruct() {
  }

  public BoxStruct(
    long id,
    long user_id,
    String box_id,
    boolean status,
    int province_id,
    int city_id)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.user_id = user_id;
    setUser_idIsSet(true);
    this.box_id = box_id;
    this.status = status;
    setStatusIsSet(true);
    this.province_id = province_id;
    setProvince_idIsSet(true);
    this.city_id = city_id;
    setCity_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BoxStruct(BoxStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.user_id = other.user_id;
    if (other.isSetBox_id()) {
      this.box_id = other.box_id;
    }
    this.status = other.status;
    this.province_id = other.province_id;
    this.city_id = other.city_id;
  }

  public BoxStruct deepCopy() {
    return new BoxStruct(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setUser_idIsSet(false);
    this.user_id = 0;
    this.box_id = null;
    setStatusIsSet(false);
    this.status = false;
    setProvince_idIsSet(false);
    this.province_id = 0;
    setCity_idIsSet(false);
    this.city_id = 0;
  }

  public long getId() {
    return this.id;
  }

  public BoxStruct setId(long id) {
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

  public long getUser_id() {
    return this.user_id;
  }

  public BoxStruct setUser_id(long user_id) {
    this.user_id = user_id;
    setUser_idIsSet(true);
    return this;
  }

  public void unsetUser_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  /** Returns true if field user_id is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_id() {
    return EncodingUtils.testBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  public void setUser_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USER_ID_ISSET_ID, value);
  }

  public String getBox_id() {
    return this.box_id;
  }

  public BoxStruct setBox_id(String box_id) {
    this.box_id = box_id;
    return this;
  }

  public void unsetBox_id() {
    this.box_id = null;
  }

  /** Returns true if field box_id is set (has been assigned a value) and false otherwise */
  public boolean isSetBox_id() {
    return this.box_id != null;
  }

  public void setBox_idIsSet(boolean value) {
    if (!value) {
      this.box_id = null;
    }
  }

  public boolean isStatus() {
    return this.status;
  }

  public BoxStruct setStatus(boolean status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public int getProvince_id() {
    return this.province_id;
  }

  public BoxStruct setProvince_id(int province_id) {
    this.province_id = province_id;
    setProvince_idIsSet(true);
    return this;
  }

  public void unsetProvince_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROVINCE_ID_ISSET_ID);
  }

  /** Returns true if field province_id is set (has been assigned a value) and false otherwise */
  public boolean isSetProvince_id() {
    return EncodingUtils.testBit(__isset_bitfield, __PROVINCE_ID_ISSET_ID);
  }

  public void setProvince_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROVINCE_ID_ISSET_ID, value);
  }

  public int getCity_id() {
    return this.city_id;
  }

  public BoxStruct setCity_id(int city_id) {
    this.city_id = city_id;
    setCity_idIsSet(true);
    return this;
  }

  public void unsetCity_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CITY_ID_ISSET_ID);
  }

  /** Returns true if field city_id is set (has been assigned a value) and false otherwise */
  public boolean isSetCity_id() {
    return EncodingUtils.testBit(__isset_bitfield, __CITY_ID_ISSET_ID);
  }

  public void setCity_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CITY_ID_ISSET_ID, value);
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

    case USER_ID:
      if (value == null) {
        unsetUser_id();
      } else {
        setUser_id((Long)value);
      }
      break;

    case BOX_ID:
      if (value == null) {
        unsetBox_id();
      } else {
        setBox_id((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Boolean)value);
      }
      break;

    case PROVINCE_ID:
      if (value == null) {
        unsetProvince_id();
      } else {
        setProvince_id((Integer)value);
      }
      break;

    case CITY_ID:
      if (value == null) {
        unsetCity_id();
      } else {
        setCity_id((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case USER_ID:
      return getUser_id();

    case BOX_ID:
      return getBox_id();

    case STATUS:
      return isStatus();

    case PROVINCE_ID:
      return getProvince_id();

    case CITY_ID:
      return getCity_id();

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
    case USER_ID:
      return isSetUser_id();
    case BOX_ID:
      return isSetBox_id();
    case STATUS:
      return isSetStatus();
    case PROVINCE_ID:
      return isSetProvince_id();
    case CITY_ID:
      return isSetCity_id();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BoxStruct)
      return this.equals((BoxStruct)that);
    return false;
  }

  public boolean equals(BoxStruct that) {
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

    boolean this_present_user_id = true;
    boolean that_present_user_id = true;
    if (this_present_user_id || that_present_user_id) {
      if (!(this_present_user_id && that_present_user_id))
        return false;
      if (this.user_id != that.user_id)
        return false;
    }

    boolean this_present_box_id = true && this.isSetBox_id();
    boolean that_present_box_id = true && that.isSetBox_id();
    if (this_present_box_id || that_present_box_id) {
      if (!(this_present_box_id && that_present_box_id))
        return false;
      if (!this.box_id.equals(that.box_id))
        return false;
    }

    boolean this_present_status = true;
    boolean that_present_status = true;
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
        return false;
    }

    boolean this_present_province_id = true;
    boolean that_present_province_id = true;
    if (this_present_province_id || that_present_province_id) {
      if (!(this_present_province_id && that_present_province_id))
        return false;
      if (this.province_id != that.province_id)
        return false;
    }

    boolean this_present_city_id = true;
    boolean that_present_city_id = true;
    if (this_present_city_id || that_present_city_id) {
      if (!(this_present_city_id && that_present_city_id))
        return false;
      if (this.city_id != that.city_id)
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

    boolean present_user_id = true;
    list.add(present_user_id);
    if (present_user_id)
      list.add(user_id);

    boolean present_box_id = true && (isSetBox_id());
    list.add(present_box_id);
    if (present_box_id)
      list.add(box_id);

    boolean present_status = true;
    list.add(present_status);
    if (present_status)
      list.add(status);

    boolean present_province_id = true;
    list.add(present_province_id);
    if (present_province_id)
      list.add(province_id);

    boolean present_city_id = true;
    list.add(present_city_id);
    if (present_city_id)
      list.add(city_id);

    return list.hashCode();
  }

  @Override
  public int compareTo(BoxStruct other) {
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
    lastComparison = Boolean.valueOf(isSetUser_id()).compareTo(other.isSetUser_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_id, other.user_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBox_id()).compareTo(other.isSetBox_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBox_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.box_id, other.box_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProvince_id()).compareTo(other.isSetProvince_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProvince_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.province_id, other.province_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCity_id()).compareTo(other.isSetCity_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCity_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.city_id, other.city_id);
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
    StringBuilder sb = new StringBuilder("BoxStruct(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_id:");
    sb.append(this.user_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("box_id:");
    if (this.box_id == null) {
      sb.append("null");
    } else {
      sb.append(this.box_id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("province_id:");
    sb.append(this.province_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("city_id:");
    sb.append(this.city_id);
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

  private static class BoxStructStandardSchemeFactory implements SchemeFactory {
    public BoxStructStandardScheme getScheme() {
      return new BoxStructStandardScheme();
    }
  }

  private static class BoxStructStandardScheme extends StandardScheme<BoxStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BoxStruct struct) throws org.apache.thrift.TException {
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
          case 2: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.user_id = iprot.readI64();
              struct.setUser_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BOX_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.box_id = iprot.readString();
              struct.setBox_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.status = iprot.readBool();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PROVINCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.province_id = iprot.readI32();
              struct.setProvince_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // CITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.city_id = iprot.readI32();
              struct.setCity_idIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, BoxStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI64(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI64(struct.user_id);
      oprot.writeFieldEnd();
      if (struct.box_id != null) {
        oprot.writeFieldBegin(BOX_ID_FIELD_DESC);
        oprot.writeString(struct.box_id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeBool(struct.status);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PROVINCE_ID_FIELD_DESC);
      oprot.writeI32(struct.province_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CITY_ID_FIELD_DESC);
      oprot.writeI32(struct.city_id);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BoxStructTupleSchemeFactory implements SchemeFactory {
    public BoxStructTupleScheme getScheme() {
      return new BoxStructTupleScheme();
    }
  }

  private static class BoxStructTupleScheme extends TupleScheme<BoxStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BoxStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetUser_id()) {
        optionals.set(1);
      }
      if (struct.isSetBox_id()) {
        optionals.set(2);
      }
      if (struct.isSetStatus()) {
        optionals.set(3);
      }
      if (struct.isSetProvince_id()) {
        optionals.set(4);
      }
      if (struct.isSetCity_id()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetUser_id()) {
        oprot.writeI64(struct.user_id);
      }
      if (struct.isSetBox_id()) {
        oprot.writeString(struct.box_id);
      }
      if (struct.isSetStatus()) {
        oprot.writeBool(struct.status);
      }
      if (struct.isSetProvince_id()) {
        oprot.writeI32(struct.province_id);
      }
      if (struct.isSetCity_id()) {
        oprot.writeI32(struct.city_id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BoxStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.user_id = iprot.readI64();
        struct.setUser_idIsSet(true);
      }
      if (incoming.get(2)) {
        struct.box_id = iprot.readString();
        struct.setBox_idIsSet(true);
      }
      if (incoming.get(3)) {
        struct.status = iprot.readBool();
        struct.setStatusIsSet(true);
      }
      if (incoming.get(4)) {
        struct.province_id = iprot.readI32();
        struct.setProvince_idIsSet(true);
      }
      if (incoming.get(5)) {
        struct.city_id = iprot.readI32();
        struct.setCity_idIsSet(true);
      }
    }
  }

}

