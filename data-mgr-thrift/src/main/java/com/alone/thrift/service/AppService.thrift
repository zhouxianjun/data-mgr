include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service AppService {
    i64 add(1: PublicStruct.AppStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.AppStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct appByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    bool changeAppFile(1: i64 id, 2: PublicStruct.ResourcesStruct resources) throws (1: PublicStruct.InvalidOperation ex);

    bool changeAppImg(1: i64 id, 2: list<PublicStruct.ResourcesStruct> resources) throws (1: PublicStruct.InvalidOperation ex);
}
