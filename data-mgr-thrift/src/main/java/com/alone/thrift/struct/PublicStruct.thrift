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
    5: string items
}
struct ResourcesStruct {
    1: i64 id,
    2: string path,
    3: string md5,
    4: i32 size,
    5: string name,
    6: i64 create_time
}
struct BoxStruct {
    1: i64 id,
    2: i64 user_id,
    3: string box_id,
    4: bool status,
    5: i32 province_id,
    6: i32 city_id
}
struct VersionStruct {
    1: i64 id,
    2: i64 resource,
    3: string version,
    4: i32 version_code,
    5: string desc
}
struct AppStruct {
    1: i64 id,
    2: string name,
    3: string zh_name,
    4: string cp_name,
    5: double price,
    6: i32 network,
    7: bool open_network,
    8: string memo,
    9: bool require,
    10: bool white,
    11: bool black
    12: i32 active_open_count,
    13: i32 active_flow,
    14: i32 active_stay_days,
    15: i32 active_show_time,
    16: bool active_open_network
}
exception InvalidOperation {
    1: i32 code,
    2: string msg
}