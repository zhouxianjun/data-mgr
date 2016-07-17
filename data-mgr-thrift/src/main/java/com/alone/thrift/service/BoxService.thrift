include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service BoxService {
    PublicStruct.PageStruct boxByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.BoxStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.BoxStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.VersionStruct updateVersion(1: PublicStruct.ResourcesStruct resources, 2: PublicStruct.VersionStruct version, 3: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);
}