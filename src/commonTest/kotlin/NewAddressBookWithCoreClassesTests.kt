import org.treeWare.model.assertMatchesJson
import org.treeWare.model.encoder.EncodePasswords
import org.treeWare.model.encoder.MultiAuxEncoder
import org.treeWare.model.encoder.StringAuxEncoder
import kotlin.test.Test

private const val AUX_NAME = "aux"

class NewAddressBookWithCoreClasses {
    @Test
    fun `JSON encoding must be correct`() {
        val model = newAddressBookWithCoreClasses(AUX_NAME)
        assertMatchesJson(
            model,
            "address_book.json",
            EncodePasswords.ALL,
            MultiAuxEncoder(AUX_NAME to StringAuxEncoder())
        )
    }
}