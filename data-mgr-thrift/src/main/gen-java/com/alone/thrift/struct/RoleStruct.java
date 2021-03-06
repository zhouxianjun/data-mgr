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
public class RoleStruct implements org.apache.thrift.TBase<RoleStruct, RoleStruct._Fields>, java.io.Serializable, Cloneable, Comparable<RoleStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RoleStruct");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PID_FIELD_DESC = new org.apache.thrift.protocol.TField("pid", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("create_time", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField UPDATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("update_time", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.BOOL, (short)7);
  private static final org.apache.thrift.protocol.TField OW_FIELD_DESC = new org.apache.thrift.protocol.TField("ow", org.apache.thrift.protocol.TType.BOOL, (short)8);
  private static final org.apache.thrift.protocol.TField ONLY_LOGIN_FIELD_DESC = new org.apache.thrift.protocol.TField("only_login", org.apache.thrift.protocol.TType.BOOL, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RoleStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RoleStructTupleSchemeFactory());
  }

  private long id; // required
  private String name; // required
  private long pid; // required
  private long create_time; // required
  private long update_time; // required
  private boolean status; // required
  private boolean ow; // optional
  private boolean only_login; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    NAME((short)2, "name"),
    PID((short)3, "pid"),
    CREATE_TIME((short)5, "create_time"),
    UPDATE_TIME((short)6, "update_time"),
    STATUS((short)7, "status"),
    OW((short)8, "ow"),
    ONLY_LOGIN((short)9, "only_login");

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
        case 3: // PID
          return PID;
        case 5: // CREATE_TIME
          return CREATE_TIME;
        case 6: // UPDATE_TIME
          return UPDATE_TIME;
        case 7: // STATUS
          return STATUS;
        case 8: // OW
          return OW;
        case 9: // ONLY_LOGIN
          return ONLY_LOGIN;
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
  private static final int __PID_ISSET_ID = 1;
  private static final int __CREATE_TIME_ISSET_ID = 2;
  private static final int __UPDATE_TIME_ISSET_ID = 3;
  private static final int __STATUS_ISSET_ID = 4;
  private static final int __OW_ISSET_ID = 5;
  private static final int __ONLY_LOGIN_ISSET_ID = 6;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.OW};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PID, new org.apache.thrift.meta_data.FieldMetaData("pid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CREATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("create_time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.UPDATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("update_time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.OW, new org.apache.thrift.meta_data.FieldMetaData("ow", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.ONLY_LOGIN, new org.apache.thrift.meta_data.FieldMetaData("only_login", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RoleStruct.class, metaDataMap);
  }

  public RoleStruct() {
  }

  public RoleStruct(
    long id,
    String name,
    long pid,
    long create_time,
    long update_time,
    boolean status,
    boolean only_login)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.name = name;
    this.pid = pid;
    setPidIsSet(true);
    this.create_time = create_time;
    setCreate_timeIsSet(true);
    this.update_time = update_time;
    setUpdate_timeIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.only_login = only_login;
    setOnly_loginIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RoleStruct(RoleStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.pid = other.pid;
    this.create_time = other.create_time;
    this.update_time = other.update_time;
    this.status = other.status;
    this.ow = other.ow;
    this.only_login = other.only_login;
  }

  public RoleStruct deepCopy() {
    return new RoleStruct(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.name = null;
    setPidIsSet(false);
    this.pid = 0;
    setCreate_timeIsSet(false);
    this.create_time = 0;
    setUpdate_timeIsSet(false);
    this.update_time = 0;
    setStatusIsSet(false);
    this.status = false;
    setOwIsSet(false);
    this.ow = false;
    setOnly_loginIsSet(false);
    this.only_login = false;
  }

  public long getId() {
    return this.id;
  }

  public RoleStruct setId(long id) {
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

  public RoleStruct setName(String name) {
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

  public long getPid() {
    return this.pid;
  }

  public RoleStruct setPid(long pid) {
    this.pid = pid;
    setPidIsSet(true);
    return this;
  }

  public void unsetPid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PID_ISSET_ID);
  }

  /** Returns true if field pid is set (has been assigned a value) and false otherwise */
  public boolean isSetPid() {
    return EncodingUtils.testBit(__isset_bitfield, __PID_ISSET_ID);
  }

  public void setPidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PID_ISSET_ID, value);
  }

  public long getCreate_time() {
    return this.create_time;
  }

  public RoleStruct setCreate_time(long create_time) {
    this.create_time = create_time;
    setCreate_timeIsSet(true);
    return this;
  }

  public void unsetCreate_time() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATE_TIME_ISSET_ID);
  }

  /** Returns true if field create_time is set (has been assigned a value) and false otherwise */
  public boolean isSetCreate_time() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATE_TIME_ISSET_ID);
  }

  public void setCreate_timeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATE_TIME_ISSET_ID, value);
  }

  public long getUpdate_time() {
    return this.update_time;
  }

  public RoleStruct setUpdate_time(long update_time) {
    this.update_time = update_time;
    setUpdate_timeIsSet(true);
    return this;
  }

  public void unsetUpdate_time() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UPDATE_TIME_ISSET_ID);
  }

  /** Returns true if field update_time is set (has been assigned a value) and false otherwise */
  public boolean isSetUpdate_time() {
    return EncodingUtils.testBit(__isset_bitfield, __UPDATE_TIME_ISSET_ID);
  }

  public void setUpdate_timeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UPDATE_TIME_ISSET_ID, value);
  }

  public boolean isStatus() {
    return this.status;
  }

  public RoleStruct setStatus(boolean status) {
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

  public boolean isOw() {
    return this.ow;
  }

  public RoleStruct setOw(boolean ow) {
    this.ow = ow;
    setOwIsSet(true);
    return this;
  }

  public void unsetOw() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OW_ISSET_ID);
  }

  /** Returns true if field ow is set (has been assigned a value) and false otherwise */
  public boolean isSetOw() {
    return EncodingUtils.testBit(__isset_bitfield, __OW_ISSET_ID);
  }

  public void setOwIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OW_ISSET_ID, value);
  }

  public boolean isOnly_login() {
    return this.only_login;
  }

  public RoleStruct setOnly_login(boolean only_login) {
    this.only_login = only_login;
    setOnly_loginIsSet(true);
    return this;
  }

  public void unsetOnly_login() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ONLY_LOGIN_ISSET_ID);
  }

  /** Returns true if field only_login is set (has been assigned a value) and false otherwise */
  public boolean isSetOnly_login() {
    return EncodingUtils.testBit(__isset_bitfield, __ONLY_LOGIN_ISSET_ID);
  }

  public void setOnly_loginIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ONLY_LOGIN_ISSET_ID, value);
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

    case PID:
      if (value == null) {
        unsetPid();
      } else {
        setPid((Long)value);
      }
      break;

    case CREATE_TIME:
      if (value == null) {
        unsetCreate_time();
      } else {
        setCreate_time((Long)value);
      }
      break;

    case UPDATE_TIME:
      if (value == null) {
        unsetUpdate_time();
      } else {
        setUpdate_time((Long)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Boolean)value);
      }
      break;

    case OW:
      if (value == null) {
        unsetOw();
      } else {
        setOw((Boolean)value);
      }
      break;

    case ONLY_LOGIN:
      if (value == null) {
        unsetOnly_login();
      } else {
        setOnly_login((Boolean)value);
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

    case PID:
      return getPid();

    case CREATE_TIME:
      return getCreate_time();

    case UPDATE_TIME:
      return getUpdate_time();

    case STATUS:
      return isStatus();

    case OW:
      return isOw();

    case ONLY_LOGIN:
      return isOnly_login();

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
    case PID:
      return isSetPid();
    case CREATE_TIME:
      return isSetCreate_time();
    case UPDATE_TIME:
      return isSetUpdate_time();
    case STATUS:
      return isSetStatus();
    case OW:
      return isSetOw();
    case ONLY_LOGIN:
      return isSetOnly_login();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RoleStruct)
      return this.equals((RoleStruct)that);
    return false;
  }

  public boolean equals(RoleStruct that) {
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

    boolean this_present_pid = true;
    boolean that_present_pid = true;
    if (this_present_pid || that_present_pid) {
      if (!(this_present_pid && that_present_pid))
        return false;
      if (this.pid != that.pid)
        return false;
    }

    boolean this_present_create_time = true;
    boolean that_present_create_time = true;
    if (this_present_create_time || that_present_create_time) {
      if (!(this_present_create_time && that_present_create_time))
        return false;
      if (this.create_time != that.create_time)
        return false;
    }

    boolean this_present_update_time = true;
    boolean that_present_update_time = true;
    if (this_present_update_time || that_present_update_time) {
      if (!(this_present_update_time && that_present_update_time))
        return false;
      if (this.update_time != that.update_time)
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

    boolean this_present_ow = true && this.isSetOw();
    boolean that_present_ow = true && that.isSetOw();
    if (this_present_ow || that_present_ow) {
      if (!(this_present_ow && that_present_ow))
        return false;
      if (this.ow != that.ow)
        return false;
    }

    boolean this_present_only_login = true;
    boolean that_present_only_login = true;
    if (this_present_only_login || that_present_only_login) {
      if (!(this_present_only_login && that_present_only_login))
        return false;
      if (this.only_login != that.only_login)
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

    boolean present_pid = true;
    list.add(present_pid);
    if (present_pid)
      list.add(pid);

    boolean present_create_time = true;
    list.add(present_create_time);
    if (present_create_time)
      list.add(create_time);

    boolean present_update_time = true;
    list.add(present_update_time);
    if (present_update_time)
      list.add(update_time);

    boolean present_status = true;
    list.add(present_status);
    if (present_status)
      list.add(status);

    boolean present_ow = true && (isSetOw());
    list.add(present_ow);
    if (present_ow)
      list.add(ow);

    boolean present_only_login = true;
    list.add(present_only_login);
    if (present_only_login)
      list.add(only_login);

    return list.hashCode();
  }

  @Override
  public int compareTo(RoleStruct other) {
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
    lastComparison = Boolean.valueOf(isSetPid()).compareTo(other.isSetPid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pid, other.pid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCreate_time()).compareTo(other.isSetCreate_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreate_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.create_time, other.create_time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpdate_time()).compareTo(other.isSetUpdate_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpdate_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.update_time, other.update_time);
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
    lastComparison = Boolean.valueOf(isSetOw()).compareTo(other.isSetOw());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOw()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ow, other.ow);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOnly_login()).compareTo(other.isSetOnly_login());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOnly_login()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.only_login, other.only_login);
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
    StringBuilder sb = new StringBuilder("RoleStruct(");
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
    sb.append("pid:");
    sb.append(this.pid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("create_time:");
    sb.append(this.create_time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("update_time:");
    sb.append(this.update_time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (isSetOw()) {
      if (!first) sb.append(", ");
      sb.append("ow:");
      sb.append(this.ow);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("only_login:");
    sb.append(this.only_login);
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

  private static class RoleStructStandardSchemeFactory implements SchemeFactory {
    public RoleStructStandardScheme getScheme() {
      return new RoleStructStandardScheme();
    }
  }

  private static class RoleStructStandardScheme extends StandardScheme<RoleStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RoleStruct struct) throws org.apache.thrift.TException {
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
          case 3: // PID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.pid = iprot.readI64();
              struct.setPidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CREATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.create_time = iprot.readI64();
              struct.setCreate_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // UPDATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.update_time = iprot.readI64();
              struct.setUpdate_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.status = iprot.readBool();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // OW
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.ow = iprot.readBool();
              struct.setOwIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // ONLY_LOGIN
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.only_login = iprot.readBool();
              struct.setOnly_loginIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RoleStruct struct) throws org.apache.thrift.TException {
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
      oprot.writeFieldBegin(PID_FIELD_DESC);
      oprot.writeI64(struct.pid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
      oprot.writeI64(struct.create_time);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(UPDATE_TIME_FIELD_DESC);
      oprot.writeI64(struct.update_time);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeBool(struct.status);
      oprot.writeFieldEnd();
      if (struct.isSetOw()) {
        oprot.writeFieldBegin(OW_FIELD_DESC);
        oprot.writeBool(struct.ow);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ONLY_LOGIN_FIELD_DESC);
      oprot.writeBool(struct.only_login);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RoleStructTupleSchemeFactory implements SchemeFactory {
    public RoleStructTupleScheme getScheme() {
      return new RoleStructTupleScheme();
    }
  }

  private static class RoleStructTupleScheme extends TupleScheme<RoleStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RoleStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetPid()) {
        optionals.set(2);
      }
      if (struct.isSetCreate_time()) {
        optionals.set(3);
      }
      if (struct.isSetUpdate_time()) {
        optionals.set(4);
      }
      if (struct.isSetStatus()) {
        optionals.set(5);
      }
      if (struct.isSetOw()) {
        optionals.set(6);
      }
      if (struct.isSetOnly_login()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetPid()) {
        oprot.writeI64(struct.pid);
      }
      if (struct.isSetCreate_time()) {
        oprot.writeI64(struct.create_time);
      }
      if (struct.isSetUpdate_time()) {
        oprot.writeI64(struct.update_time);
      }
      if (struct.isSetStatus()) {
        oprot.writeBool(struct.status);
      }
      if (struct.isSetOw()) {
        oprot.writeBool(struct.ow);
      }
      if (struct.isSetOnly_login()) {
        oprot.writeBool(struct.only_login);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RoleStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.pid = iprot.readI64();
        struct.setPidIsSet(true);
      }
      if (incoming.get(3)) {
        struct.create_time = iprot.readI64();
        struct.setCreate_timeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.update_time = iprot.readI64();
        struct.setUpdate_timeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.status = iprot.readBool();
        struct.setStatusIsSet(true);
      }
      if (incoming.get(6)) {
        struct.ow = iprot.readBool();
        struct.setOwIsSet(true);
      }
      if (incoming.get(7)) {
        struct.only_login = iprot.readBool();
        struct.setOnly_loginIsSet(true);
      }
    }
  }

}

