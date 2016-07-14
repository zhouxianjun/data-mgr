namespace java com.alone.thrift.struct
struct RoleStruct {
    1: i64 id,
    2: string name,
    3: i64 pid,
    5: i64 create_time,
    6: i64 update_time,
    7: bool status,
    8: optional bool ow
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
    10: optional string icon,
    11: optional bool ow
}
struct InterfaceStruct {
    1: i64 id,
    2: string name,
    3: string auth,
    4: optional string description,
    5: i32 seq,
    6: bool status,
    7: i64 create_time,
    8: optional bool ow
}
struct UserStruct {
    1: i64 id,
    2: string username,
    3: string password,
    4: string name,
    5: string real_name,
    6: optional string company,
    7: i32 city_id,
    8: i32 province_id,
    9: string email,
    10: string phone,
    11: i64 create_time
    12: bool status
    13: i64 pid,
    14: string pids
}
struct PageParamStruct {
    1: optional i32 page = 1,
    2: optional i32 pageSize = 15,
    3: optional string sortName,
    4: optional string sortDir
}
struct PageStruct {
    1: i32 pageNum,
    2: i32 pageSize,
    3: i32 count,
    4: i32 current,
    5: list<string> items
}
exception InvalidOperation {
    1: i32 code,
    2: string msg
}