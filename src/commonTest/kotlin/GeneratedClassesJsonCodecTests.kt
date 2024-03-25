import addressBook.main.AddressBookColor
import addressBook.main.AddressBookRelationship
import org.treeWare.model.assertMatchesJson
import org.treeWare.model.decoder.stateMachine.MultiAuxDecodingStateMachineFactory
import org.treeWare.model.decoder.stateMachine.StringAuxStateMachine
import org.treeWare.model.encoder.EncodePasswords
import org.treeWare.model.encoder.MultiAuxEncoder
import org.treeWare.model.encoder.StringAuxEncoder
import org.treeWare.model.getMainModelFromJsonFile
import org.treeWare.model.testRoundTrip
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

    @Test
    fun elements_in_decoded_model_must_be_readable() {
        val auxName = "aux"
        val mutableModel = MutableAddressBook()
        getMainModelFromJsonFile(
            meta = addressBookMetaModel,
            "address_book.json",
            multiAuxDecodingStateMachineFactory = MultiAuxDecodingStateMachineFactory(auxName to {
                StringAuxStateMachine(it)
            }),
            mainModel = mutableModel,
        )
        // Also access the model via the read-only interface.
        val model: AddressBook = mutableModel

        // Access the paths in the decoded model.
        assertNotNull(model.modelRoot)
        assertNotNull(mutableModel.modelRoot)
        assertEquals("Address Book", model.modelRoot?.name)
        assertEquals("Address Book", mutableModel.modelRoot?.name)
        assertEquals(1587147731UL, model.modelRoot?.lastUpdated)
        assertEquals(1587147731UL, mutableModel.modelRoot?.lastUpdated)

        assertNotNull(model.modelRoot?.settings)
        assertNotNull(mutableModel.modelRoot?.settings)
        assertEquals(true, model.modelRoot?.settings?.lastNameFirst)
        assertEquals(true, mutableModel.modelRoot?.settings?.lastNameFirst)
        assertEquals(false, model.modelRoot?.settings?.encryptHeroName)
        assertEquals(false, mutableModel.modelRoot?.settings?.encryptHeroName)
        assertEquals(AddressBookColor.WHITE, model.modelRoot?.settings?.backgroundColor)
        assertEquals(AddressBookColor.WHITE, mutableModel.modelRoot?.settings?.backgroundColor)

        assertEquals(AddressBookColor.VIOLET, model.modelRoot?.settings?.advanced?.borderColor)
        assertEquals(AddressBookColor.VIOLET, mutableModel.modelRoot?.settings?.advanced?.borderColor)

        assertEquals(2, model.modelRoot?.groups?.count())
        assertEquals(2, mutableModel.modelRoot?.groups?.count())
        //
        val group0 = model.modelRoot?.groups?.elementAt(0)
        val mutableGroup0 = mutableModel.modelRoot?.groups?.elementAt(0)
        assertEquals("DC", group0?.name)
        assertEquals("DC", mutableGroup0?.name)
        assertEquals(1, group0?.subGroups?.count())
        assertEquals(1, mutableGroup0?.subGroups?.count())
        ////
        // TODO: the following self-referential entity access fails
        // assertEquals("Superman", group0?.subGroups?.elementAt(0)?.name)
        // assertEquals("Superman", mutableGroup0?.subGroups?.elementAt(0)?.name)
        //
        val group1 = model.modelRoot?.groups?.elementAt(1)
        val mutableGroup1 = mutableModel.modelRoot?.groups?.elementAt(1)
        assertEquals("Marvel", group1?.name)
        assertEquals("Marvel", mutableGroup1?.name)

        assertEquals(2, model.modelRoot?.person?.count())
        assertEquals(2, mutableModel.modelRoot?.person?.count())
        //
        val person0 = model.modelRoot?.person?.elementAt(0)
        val mutablePerson0 = mutableModel.modelRoot?.person?.elementAt(0)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", person0?.id)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", mutablePerson0?.id)
        assertEquals("Clark", person0?.firstName)
        assertEquals("Clark", mutablePerson0?.firstName)
        assertEquals("Kent", person0?.lastName)
        assertEquals("Kent", mutablePerson0?.lastName)
        assertEquals("Superman", person0?.heroName)
        assertEquals("Superman", mutablePerson0?.heroName)
        assertEquals("kryptonite", person0?.password?.unhashed)
        assertEquals("kryptonite", mutablePerson0?.password?.unhashed)
        assertEquals(null, person0?.password?.hashed)
        assertEquals(null, mutablePerson0?.password?.hashed)
        assertEquals(0, person0?.password?.hashVersion)
        assertEquals(0, mutablePerson0?.password?.hashVersion)
        assertEquals("Alien from Krypton", person0?.mainSecret?.unencrypted)
        assertEquals("Alien from Krypton", mutablePerson0?.mainSecret?.unencrypted)
        assertEquals(null, person0?.mainSecret?.encrypted)
        assertEquals(null, mutablePerson0?.mainSecret?.encrypted)
        assertEquals(0, person0?.mainSecret?.cipherVersion)
        assertEquals(0, mutablePerson0?.mainSecret?.cipherVersion)
        assertEquals(1, person0?.relation?.count())
        assertEquals(1, mutablePerson0?.relation?.count())
        ////
        val person0Relation0 = person0?.relation?.elementAt(0)
        val mutablePerson0Relation0 = mutablePerson0?.relation?.elementAt(0)
        assertEquals("05ade278-4b44-43da-a0cc-14463854e397", person0Relation0?.id)
        assertEquals("05ade278-4b44-43da-a0cc-14463854e397", mutablePerson0Relation0?.id)
        assertEquals(AddressBookRelationship.COLLEAGUE, person0Relation0?.relationship)
        assertEquals(AddressBookRelationship.COLLEAGUE, mutablePerson0Relation0?.relationship)
        //
        val person1 = model.modelRoot?.person?.elementAt(1)
        val mutablePerson1 = mutableModel.modelRoot?.person?.elementAt(1)
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", person1?.id)
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", mutablePerson1?.id)
        assertEquals("Lois", person1?.firstName)
        assertEquals("Lois", mutablePerson1?.firstName)
        assertEquals("Lane", person1?.lastName)
        assertEquals("Lane", mutablePerson1?.lastName)
        assertEquals(null, person1?.password?.unhashed)
        assertEquals(null, mutablePerson1?.password?.unhashed)
        assertEquals("test-hashed-lois", person1?.password?.hashed)
        assertEquals("test-hashed-lois", mutablePerson1?.password?.hashed)
        assertEquals(1, person1?.password?.hashVersion)
        assertEquals(1, mutablePerson1?.password?.hashVersion)
        assertEquals(null, person1?.mainSecret?.unencrypted)
        assertEquals(null, mutablePerson1?.mainSecret?.unencrypted)
        assertEquals("test-encrypted-main-secret", person1?.mainSecret?.encrypted)
        assertEquals("test-encrypted-main-secret", mutablePerson1?.mainSecret?.encrypted)
        assertEquals(1, person1?.mainSecret?.cipherVersion)
        assertEquals(1, mutablePerson1?.mainSecret?.cipherVersion)
        assertEquals(1, person1?.relation?.count())
        assertEquals(1, mutablePerson1?.relation?.count())
        ////
        val person1Relation0 = person1?.relation?.elementAt(0)
        val mutablePerson1Relation0 = mutablePerson1?.relation?.elementAt(0)
        assertEquals("16634916-8f83-4376-ad42-37038e108a0b", person1Relation0?.id)
        assertEquals("16634916-8f83-4376-ad42-37038e108a0b", mutablePerson1Relation0?.id)
        assertEquals(AddressBookRelationship.COLLEAGUE, person1Relation0?.relationship)
        assertEquals(AddressBookRelationship.COLLEAGUE, mutablePerson1Relation0?.relationship)

//        assertNotNull(mutableModel.modelRoot?.cityInfo)
//        assertNotNull(mutableModel.modelRoot?.cityInfo)

        // TODO: test association fields

        // Encode the model to JSON and compare against the original to ensure that reading the elements in the model
        // does not create new elements. Test both `model` and `mutableModel` in case there are differences in their
        // generated implementation.
        assertMatchesJson(
            model,
            "address_book.json",
            EncodePasswords.ALL,
            MultiAuxEncoder(auxName to StringAuxEncoder()),
        )
        assertMatchesJson(
            mutableModel,
            "address_book.json",
            EncodePasswords.ALL,
            MultiAuxEncoder(auxName to StringAuxEncoder()),
        )
    }
}