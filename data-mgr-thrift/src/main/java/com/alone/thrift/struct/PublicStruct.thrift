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
    12: i64 active_id
}
struct AppRequireStruct {
    1: i64 id,
    2: string name,
    3: i64 resources_id,
    4: i32 type,
    5: string memo
}
struct AppWhiteStruct {
    1: i64 id,
    2: string name,
    3: i64 resources_id,
    4: string memo,
    5: string version,
    6: i64 brand_id,
    7: i64 model_id,
    8: i64 version_id,
    9: i64 base_version_id
}
struct AppActiveStruct {
    1: i64 id,
    2: string name,
    3: i32 open_count,
    4: i32 flow,
    5: i32 stay_days,
    6: i32 show_time,
    7: bool open_network
}
struct PackageStruct {
    1: i64 id,
    2: string name,
    3: double price
}
struct AppPackageStruct {
    1: i64 id,
    2: string name,
    3: bool common,
    4: bool root,
    5: optional i64 brand_id,
    6: optional i64 model_id,
    7: optional i64 version_id,
    8: optional i64 base_version_id,
    9: i64 package_id,
    10: optional list<i64> pre,
    11: optional list<i64> install
}
struct RequirePackageStruct {
    1: i64 id,
    2: string name,
    3: string android_version,
    4: bool root,
    5: optional list<i64> pre,
    6: optional list<i64> install
}
struct RootModelStruct {
    1: i64 id,
    2: i64 brand_id,
    3: i64 model_id,
    4: i64 version_id,
    5: i64 base_version_id
}
struct RootConfigStruct {
    1: i64 id,
    2: string name,
    3: string version,
    4: string memo,
    5: i64 resources_id
}
struct PushStruct {
    1: i64 id,
    2: i64 user_id,
    3: string name,
    4: i32 type,
    5: optional ResourcesStruct img,
    6: optional string text,
    7: i32 client_type,
    8: optional ResourcesStruct app,
    9: optional double deduct,
    10: optional string url,
    11: i32 status
}
struct InstallActiveStruct {
    1: i64 id,
    2: string name,
    3: string memo,
    4: i32 hours
}
exception InvalidOperation {
    1: i32 code,
    2: string msg
}