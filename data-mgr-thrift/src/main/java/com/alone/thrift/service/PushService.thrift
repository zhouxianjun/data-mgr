include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service PushService {
    i64 add(1: PublicStruct.PushStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.PushStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool changeImg(1: PublicStruct.ResourcesStruct bean, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool changeApp(1: PublicStruct.ResourcesStruct bean, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    string listUnRead(1: i64 user, 2: string client_code, 3: i32 type, 4: string url) throws (1: PublicStruct.InvalidOperation ex);

    bool readPush(1: i64 user, 2: string client_code, 3: i32 type, 4: i64 push) throws (1: PublicStruct.InvalidOperation ex);
}
