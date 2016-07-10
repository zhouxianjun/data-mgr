namespace java com.alone.thrift.struct
struct RoleStruct {
    1: i64 id,
    2: string name,
    3: i64 pid,
    5: i64 create_time,
    6: i64 update_time,
    7: bool status
}
struct MenuStruct {
    1: i64 id,
    2: string name,
    3: i64 pid,
    4: optional string description,
    5: i32 seq,
    6: bool status,
    7: i64 create_time,
    8: optional string path,
    9: string target,
    10: optional string icon
}
exception InvalidOperation {
    1: i32 code,
    2: string msg
}