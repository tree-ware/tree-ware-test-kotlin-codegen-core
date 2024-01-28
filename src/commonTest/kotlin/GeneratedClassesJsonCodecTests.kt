import org.treeWare.model.decoder.stateMachine.MultiAuxDecodingStateMachineFactory
import org.treeWare.model.decoder.stateMachine.StringAuxStateMachine
import org.treeWare.model.encoder.EncodePasswords
import org.treeWare.model.encoder.MultiAuxEncoder
import org.treeWare.model.encoder.StringAuxEncoder
import org.treeWare.model.testRoundTrip
import kotlin.test.Test

class GeneratedClassesJsonCodecTests {
    @Test
    fun json_codec_round_trip_must_be_lossless() {
        val auxName = "aux"
        testRoundTrip(
            "address_book.json",
            multiAuxEncoder = MultiAuxEncoder(auxName to StringAuxEncoder()),
            encodePasswords = EncodePasswords.ALL,
            multiAuxDecodingStateMachineFactory = MultiAuxDecodingStateMachineFactory(auxName to {
                StringAuxStateMachine(it)
            }),
            metaModel = addressBookMetaModel,
            mainModel = MutableAddressBook(),
        )
    }
}