include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service RequirePackageService {
    i64 add(1: PublicStruct.RequirePackageStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.RequirePackageStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listAppByPage(1: PublicStruct.PageParamStruct page, 2: i32 type, 3: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    string appAllList(1: i64 id, 2: i32 type) throws (1: PublicStruct.InvalidOperation ex);

    bool removeApp(1: i64 id, 2: i64 app, 3: i32 type) throws (1: PublicStruct.InvalidOperation ex);

    string allList(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);
}
