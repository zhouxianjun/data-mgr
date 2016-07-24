include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service PushService {
    i64 add(1: PublicStruct.PushStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.PushStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool changeImg(1: PublicStruct.ResourcesStruct bean, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool changeApp(1: PublicStruct.ResourcesStruct bean, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);
}
