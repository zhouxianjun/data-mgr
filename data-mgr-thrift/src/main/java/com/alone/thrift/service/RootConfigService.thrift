include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service RootConfigService {
    i64 add(1: PublicStruct.RootConfigStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.RootConfigStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool addModel(1: PublicStruct.RootModelStruct model, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool removeModel(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listModelByPage(1: PublicStruct.PageParamStruct page, 2: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool changeAppFile(1: i64 id, 2: PublicStruct.ResourcesStruct resources) throws (1: PublicStruct.InvalidOperation ex);

}
