import org.treeWare.metaModel.newMetaModelFromJsonFiles

val ADDRESS_BOOK_META_MODEL_FILES = listOf(
    "tree_ware/meta_model/address_book_root.json",
    "tree_ware/meta_model/address_book_main.json",
    "tree_ware/meta_model/address_book_city.json",
    "tree_ware/meta_model/geo.json"
)

val addressBookMetaModel = newMetaModelFromJsonFiles(
    ADDRESS_BOOK_META_MODEL_FILES, false, null, null, emptyList(), true
).metaModel ?: throw IllegalStateException("Meta-model has validation errors")