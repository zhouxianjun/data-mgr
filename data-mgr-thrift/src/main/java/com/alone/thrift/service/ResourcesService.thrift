include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ResourcesService {
    PublicStruct.ResourcesStruct getByVersion(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.ResourcesStruct getByMD5(1: string md5) throws (1: PublicStruct.InvalidOperation ex);
}