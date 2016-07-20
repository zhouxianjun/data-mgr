include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ModelMgrService {
    i64 addBrand(1: string name) throws (1: PublicStruct.InvalidOperation ex);

    bool removeBrand(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    i64 addModel(1: string name, 2: i64 brand) throws (1: PublicStruct.InvalidOperation ex);

    bool removeModel(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    i64 addVersion(1: string name, 2: i64 model) throws (1: PublicStruct.InvalidOperation ex);

    bool removeVersion(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    i64 addBaseVersion(1: string name, 2: i64 version) throws (1: PublicStruct.InvalidOperation ex);

    bool removeBaseVersion(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct brandByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct modelByPage(1: PublicStruct.PageParamStruct page, 2: i64 brand) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct versionByPage(1: PublicStruct.PageParamStruct page, 2: i64 model) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct baseVersionByPage(1: PublicStruct.PageParamStruct page, 2: i64 version) throws (1: PublicStruct.InvalidOperation ex);
}
