include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ResourcesService {
    bool save(1: PublicStruct.ResourcesStruct bean) throws (1: PublicStruct.InvalidOperation ex);
}