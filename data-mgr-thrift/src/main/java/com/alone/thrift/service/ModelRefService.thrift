include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ModelRefService {
    i64 add(1: PublicStruct.ModelStruct bean, 2: i64 ref, 3: i32 type) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 ref, 2: i64 model, 3: i32 type) throws (1: PublicStruct.InvalidOperation ex);

    bool removeModel(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listModelByPage(1: PublicStruct.PageParamStruct page, 2: i64 ref, 3: i32 type) throws (1: PublicStruct.InvalidOperation ex);
}
