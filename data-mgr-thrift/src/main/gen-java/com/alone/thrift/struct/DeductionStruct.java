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
public class DeductionStruct implements org.apache.thrift.TBase<DeductionStruct, DeductionStruct._Fields>, java.io.Serializable, Cloneable, Comparable<DeductionStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DeductionStruct");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PERCENT_FIELD_DESC = new org.apache.thrift.protocol.TField("percent", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField START_FIELD_DESC = new org.apache.thrift.protocol.TField("start", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField MODEL_FIELD_DESC = new org.apache.thrift.protocol.TField("model", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("start_time", org.apache.thrift.protocol.TType.I64, (short)7);
  private static final org.apache.thrift.protocol.TField END_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("end_time", org.apache.thrift.protocol.TType.I64, (short)8);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("user_id", org.apache.thrift.protocol.TType.I64, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DeductionStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DeductionStructTupleSchemeFactory());
  }

  private long id; // required
  private String name; // required
  private int percent; // required
  private int start; // required
  private int model; // required
  private boolean status; // required
  private long start_time; // required
  private long end_time; // required
  private long user_id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    NAME((short)2, "name"),
    PERCENT((short)3, "percent"),
    START((short)4, "start"),
    MODEL((short)5, "model"),
    STATUS((short)6, "status"),
    START_TIME((short)7, "start_time"),
    END_TIME((short)8, "end_time"),
    USER_ID((short)9, "user_id");

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
        case 3: // PERCENT
          return PERCENT;
        case 4: // START
          return START;
        case 5: // MODEL
          return MODEL;
        case 6: // STATUS
          return STATUS;
        case 7: // START_TIME
          return START_TIME;
        case 8: // END_TIME
          return END_TIME;
        case 9: // USER_ID
          return USER_ID;
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
  private static final int __PERCENT_ISSET_ID = 1;
  private static final int __START_ISSET_ID = 2;
  private static final int __MODEL_ISSET_ID = 3;
  private static final int __STATUS_ISSET_ID = 4;
  private static final int __START_TIME_ISSET_ID = 5;
  private static final int __END_TIME_ISSET_ID = 6;
  private static final int __USER_ID_ISSET_ID = 7;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PERCENT, new org.apache.thrift.meta_data.FieldMetaData("percent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.START, new org.apache.thrift.meta_data.FieldMetaData("start", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MODEL, new org.apache.thrift.meta_data.FieldMetaData("model", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("start_time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.END_TIME, new org.apache.thrift.meta_data.FieldMetaData("end_time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("user_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DeductionStruct.class, metaDataMap);
  }

  public DeductionStruct() {
  }

  public DeductionStruct(
    long id,
    String name,
    int percent,
    int start,
    int model,
    boolean status,
    long start_time,
    long end_time,
    long user_id)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.name = name;
    this.percent = percent;
    setPercentIsSet(true);
    this.start = start;
    setStartIsSet(true);
    this.model = model;
    setModelIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.start_time = start_time;
    setStart_timeIsSet(true);
    this.end_time = end_time;
    setEnd_timeIsSet(true);
    this.user_id = user_id;
    setUser_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DeductionStruct(DeductionStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.percent = other.percent;
    this.start = other.start;
    this.model = other.model;
    this.status = other.status;
    this.start_time = other.start_time;
    this.end_time = other.end_time;
    this.user_id = other.user_id;
  }

  public DeductionStruct deepCopy() {
    return new DeductionStruct(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.name = null;
    setPercentIsSet(false);
    this.percent = 0;
    setStartIsSet(false);
    this.start = 0;
    setModelIsSet(false);
    this.model = 0;
    setStatusIsSet(false);
    this.status = false;
    setStart_timeIsSet(false);
    this.start_time = 0;
    setEnd_timeIsSet(false);
    this.end_time = 0;
    setUser_idIsSet(false);
    this.user_id = 0;
  }

  public long getId() {
    return this.id;
  }

  public DeductionStruct setId(long id) {
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

  public DeductionStruct setName(String name) {
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

  public int getPercent() {
    return this.percent;
  }

  public DeductionStruct setPercent(int percent) {
    this.percent = percent;
    setPercentIsSet(true);
    return this;
  }

  public void unsetPercent() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PERCENT_ISSET_ID);
  }

  /** Returns true if field percent is set (has been assigned a value) and false otherwise */
  public boolean isSetPercent() {
    return EncodingUtils.testBit(__isset_bitfield, __PERCENT_ISSET_ID);
  }

  public void setPercentIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PERCENT_ISSET_ID, value);
  }

  public int getStart() {
    return this.start;
  }

  public DeductionStruct setStart(int start) {
    this.start = start;
    setStartIsSet(true);
    return this;
  }

  public void unsetStart() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __START_ISSET_ID);
  }

  /** Returns true if field start is set (has been assigned a value) and false otherwise */
  public boolean isSetStart() {
    return EncodingUtils.testBit(__isset_bitfield, __START_ISSET_ID);
  }

  public void setStartIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __START_ISSET_ID, value);
  }

  public int getModel() {
    return this.model;
  }

  public DeductionStruct setModel(int model) {
    this.model = model;
    setModelIsSet(true);
    return this;
  }

  public void unsetModel() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MODEL_ISSET_ID);
  }

  /** Returns true if field model is set (has been assigned a value) and false otherwise */
  public boolean isSetModel() {
    return EncodingUtils.testBit(__isset_bitfield, __MODEL_ISSET_ID);
  }

  public void setModelIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MODEL_ISSET_ID, value);
  }

  public boolean isStatus() {
    return this.status;
  }

  public DeductionStruct setStatus(boolean status) {
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

  public long getStart_time() {
    return this.start_time;
  }

  public DeductionStruct setStart_time(long start_time) {
    this.start_time = start_time;
    setStart_timeIsSet(true);
    return this;
  }

  public void unsetStart_time() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __START_TIME_ISSET_ID);
  }

  /** Returns true if field start_time is set (has been assigned a value) and false otherwise */
  public boolean isSetStart_time() {
    return EncodingUtils.testBit(__isset_bitfield, __START_TIME_ISSET_ID);
  }

  public void setStart_timeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __START_TIME_ISSET_ID, value);
  }

  public long getEnd_time() {
    return this.end_time;
  }

  public DeductionStruct setEnd_time(long end_time) {
    this.end_time = end_time;
    setEnd_timeIsSet(true);
    return this;
  }

  public void unsetEnd_time() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __END_TIME_ISSET_ID);
  }

  /** Returns true if field end_time is set (has been assigned a value) and false otherwise */
  public boolean isSetEnd_time() {
    return EncodingUtils.testBit(__isset_bitfield, __END_TIME_ISSET_ID);
  }

  public void setEnd_timeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __END_TIME_ISSET_ID, value);
  }

  public long getUser_id() {
    return this.user_id;
  }

  public DeductionStruct setUser_id(long user_id) {
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

    case PERCENT:
      if (value == null) {
        unsetPercent();
      } else {
        setPercent((Integer)value);
      }
      break;

    case START:
      if (value == null) {
        unsetStart();
      } else {
        setStart((Integer)value);
      }
      break;

    case MODEL:
      if (value == null) {
        unsetModel();
      } else {
        setModel((Integer)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Boolean)value);
      }
      break;

    case START_TIME:
      if (value == null) {
        unsetStart_time();
      } else {
        setStart_time((Long)value);
      }
      break;

    case END_TIME:
      if (value == null) {
        unsetEnd_time();
      } else {
        setEnd_time((Long)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUser_id();
      } else {
        setUser_id((Long)value);
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

    case PERCENT:
      return getPercent();

    case START:
      return getStart();

    case MODEL:
      return getModel();

    case STATUS:
      return isStatus();

    case START_TIME:
      return getStart_time();

    case END_TIME:
      return getEnd_time();

    case USER_ID:
      return getUser_id();

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
    case PERCENT:
      return isSetPercent();
    case START:
      return isSetStart();
    case MODEL:
      return isSetModel();
    case STATUS:
      return isSetStatus();
    case START_TIME:
      return isSetStart_time();
    case END_TIME:
      return isSetEnd_time();
    case USER_ID:
      return isSetUser_id();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DeductionStruct)
      return this.equals((DeductionStruct)that);
    return false;
  }

  public boolean equals(DeductionStruct that) {
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

    boolean this_present_percent = true;
    boolean that_present_percent = true;
    if (this_present_percent || that_present_percent) {
      if (!(this_present_percent && that_present_percent))
        return false;
      if (this.percent != that.percent)
        return false;
    }

    boolean this_present_start = true;
    boolean that_present_start = true;
    if (this_present_start || that_present_start) {
      if (!(this_present_start && that_present_start))
        return false;
      if (this.start != that.start)
        return false;
    }

    boolean this_present_model = true;
    boolean that_present_model = true;
    if (this_present_model || that_present_model) {
      if (!(this_present_model && that_present_model))
        return false;
      if (this.model != that.model)
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

    boolean this_present_start_time = true;
    boolean that_present_start_time = true;
    if (this_present_start_time || that_present_start_time) {
      if (!(this_present_start_time && that_present_start_time))
        return false;
      if (this.start_time != that.start_time)
        return false;
    }

    boolean this_present_end_time = true;
    boolean that_present_end_time = true;
    if (this_present_end_time || that_present_end_time) {
      if (!(this_present_end_time && that_present_end_time))
        return false;
      if (this.end_time != that.end_time)
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

    boolean present_percent = true;
    list.add(present_percent);
    if (present_percent)
      list.add(percent);

    boolean present_start = true;
    list.add(present_start);
    if (present_start)
      list.add(start);

    boolean present_model = true;
    list.add(present_model);
    if (present_model)
      list.add(model);

    boolean present_status = true;
    list.add(present_status);
    if (present_status)
      list.add(status);

    boolean present_start_time = true;
    list.add(present_start_time);
    if (present_start_time)
      list.add(start_time);

    boolean present_end_time = true;
    list.add(present_end_time);
    if (present_end_time)
      list.add(end_time);

    boolean present_user_id = true;
    list.add(present_user_id);
    if (present_user_id)
      list.add(user_id);

    return list.hashCode();
  }

  @Override
  public int compareTo(DeductionStruct other) {
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
    lastComparison = Boolean.valueOf(isSetPercent()).compareTo(other.isSetPercent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPercent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.percent, other.percent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStart()).compareTo(other.isSetStart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.start, other.start);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetModel()).compareTo(other.isSetModel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.model, other.model);
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
    lastComparison = Boolean.valueOf(isSetStart_time()).compareTo(other.isSetStart_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStart_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.start_time, other.start_time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnd_time()).compareTo(other.isSetEnd_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnd_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.end_time, other.end_time);
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
    StringBuilder sb = new StringBuilder("DeductionStruct(");
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
    sb.append("percent:");
    sb.append(this.percent);
    first = false;
    if (!first) sb.append(", ");
    sb.append("start:");
    sb.append(this.start);
    first = false;
    if (!first) sb.append(", ");
    sb.append("model:");
    sb.append(this.model);
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("start_time:");
    sb.append(this.start_time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("end_time:");
    sb.append(this.end_time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_id:");
    sb.append(this.user_id);
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

  private static class DeductionStructStandardSchemeFactory implements SchemeFactory {
    public DeductionStructStandardScheme getScheme() {
      return new DeductionStructStandardScheme();
    }
  }

  private static class DeductionStructStandardScheme extends StandardScheme<DeductionStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DeductionStruct struct) throws org.apache.thrift.TException {
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
          case 3: // PERCENT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.percent = iprot.readI32();
              struct.setPercentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // START
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.start = iprot.readI32();
              struct.setStartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MODEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.model = iprot.readI32();
              struct.setModelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.status = iprot.readBool();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.start_time = iprot.readI64();
              struct.setStart_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // END_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.end_time = iprot.readI64();
              struct.setEnd_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.user_id = iprot.readI64();
              struct.setUser_idIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DeductionStruct struct) throws org.apache.thrift.TException {
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
      oprot.writeFieldBegin(PERCENT_FIELD_DESC);
      oprot.writeI32(struct.percent);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(START_FIELD_DESC);
      oprot.writeI32(struct.start);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MODEL_FIELD_DESC);
      oprot.writeI32(struct.model);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeBool(struct.status);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(START_TIME_FIELD_DESC);
      oprot.writeI64(struct.start_time);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(END_TIME_FIELD_DESC);
      oprot.writeI64(struct.end_time);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI64(struct.user_id);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DeductionStructTupleSchemeFactory implements SchemeFactory {
    public DeductionStructTupleScheme getScheme() {
      return new DeductionStructTupleScheme();
    }
  }

  private static class DeductionStructTupleScheme extends TupleScheme<DeductionStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DeductionStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetPercent()) {
        optionals.set(2);
      }
      if (struct.isSetStart()) {
        optionals.set(3);
      }
      if (struct.isSetModel()) {
        optionals.set(4);
      }
      if (struct.isSetStatus()) {
        optionals.set(5);
      }
      if (struct.isSetStart_time()) {
        optionals.set(6);
      }
      if (struct.isSetEnd_time()) {
        optionals.set(7);
      }
      if (struct.isSetUser_id()) {
        optionals.set(8);
      }
      oprot.writeBitSet(optionals, 9);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetPercent()) {
        oprot.writeI32(struct.percent);
      }
      if (struct.isSetStart()) {
        oprot.writeI32(struct.start);
      }
      if (struct.isSetModel()) {
        oprot.writeI32(struct.model);
      }
      if (struct.isSetStatus()) {
        oprot.writeBool(struct.status);
      }
      if (struct.isSetStart_time()) {
        oprot.writeI64(struct.start_time);
      }
      if (struct.isSetEnd_time()) {
        oprot.writeI64(struct.end_time);
      }
      if (struct.isSetUser_id()) {
        oprot.writeI64(struct.user_id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DeductionStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(9);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.percent = iprot.readI32();
        struct.setPercentIsSet(true);
      }
      if (incoming.get(3)) {
        struct.start = iprot.readI32();
        struct.setStartIsSet(true);
      }
      if (incoming.get(4)) {
        struct.model = iprot.readI32();
        struct.setModelIsSet(true);
      }
      if (incoming.get(5)) {
        struct.status = iprot.readBool();
        struct.setStatusIsSet(true);
      }
      if (incoming.get(6)) {
        struct.start_time = iprot.readI64();
        struct.setStart_timeIsSet(true);
      }
      if (incoming.get(7)) {
        struct.end_time = iprot.readI64();
        struct.setEnd_timeIsSet(true);
      }
      if (incoming.get(8)) {
        struct.user_id = iprot.readI64();
        struct.setUser_idIsSet(true);
      }
    }
  }

}

