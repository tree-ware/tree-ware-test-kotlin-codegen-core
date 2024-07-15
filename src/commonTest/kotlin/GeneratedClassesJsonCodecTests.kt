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
        assertEquals("Superman", group0?.subGroups?.elementAt(0)?.name)
        assertEquals("Superman", mutableGroup0?.subGroups?.elementAt(0)?.name)
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
        val person0Relation0Person = person0Relation0?.person
        val mutablePerson0Relation0Person = mutablePerson0Relation0?.person
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", person0Relation0Person?.person?.elementAt(0)?.id)
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", mutablePerson0Relation0Person?.person?.elementAt(0)?.id)
        //
        val person0Group = person0?.group
        val mutablePerson0Group = mutablePerson0?.group
        assertEquals("DC", person0Group?.groups?.elementAt(0)?.name)
        assertEquals("DC", mutablePerson0Group?.groups?.elementAt(0)?.name)
        assertEquals("Superman", person0Group?.groups?.elementAt(0)?.subGroups?.elementAt(0)?.name)
        assertEquals("Superman", mutablePerson0Group?.groups?.elementAt(0)?.subGroups?.elementAt(0)?.name)
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
        val person1Relation0Person = person1Relation0?.person
        val mutablePerson1Relation0Person = mutablePerson1Relation0?.person
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", person1Relation0Person?.person?.elementAt(0)?.id)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", mutablePerson1Relation0Person?.person?.elementAt(0)?.id)
        //
        val person1Group = person1?.group
        val mutablePerson1Group = mutablePerson1?.group
        assertEquals("DC", person1Group?.groups?.elementAt(0)?.name)
        assertEquals("DC", mutablePerson1Group?.groups?.elementAt(0)?.name)
        assertEquals("Superman", person1Group?.groups?.elementAt(0)?.subGroups?.elementAt(0)?.name)
        assertEquals("Superman", mutablePerson1Group?.groups?.elementAt(0)?.subGroups?.elementAt(0)?.name)

        assertEquals(4, model.modelRoot?.cityInfo?.count())
        assertEquals(4, mutableModel.modelRoot?.cityInfo?.count())
        //
        val cityInfo0 = model.modelRoot?.cityInfo?.elementAt(0)
        val mutableCityInfo0 = mutableModel.modelRoot?.cityInfo?.elementAt(0)
        ////
        val cityInfo0City = cityInfo0?.city
        val mutableCityInfo0City = mutableCityInfo0?.city
        assertEquals("New York City", cityInfo0City?.name)
        assertEquals("New York City", mutableCityInfo0City?.name)
        assertEquals("New York", cityInfo0City?.state)
        assertEquals("New York", mutableCityInfo0City?.state)
        assertEquals("United States of America", cityInfo0City?.country)
        assertEquals("United States of America", mutableCityInfo0City?.country)
        //
        assertEquals("One of the most populous and most densely populated major city in USA", cityInfo0?.info)
        assertEquals("One of the most populous and most densely populated major city in USA", mutableCityInfo0?.info)
        //
        val cityInfo1 = model.modelRoot?.cityInfo?.elementAt(1)
        val mutableCityInfo1 = mutableModel.modelRoot?.cityInfo?.elementAt(1)
        ////
        val cityInfo1City = cityInfo1?.city
        val mutableCityInfo1City = mutableCityInfo1?.city
        assertEquals("Albany", cityInfo1City?.name)
        assertEquals("Albany", mutableCityInfo1City?.name)
        assertEquals("New York", cityInfo1City?.state)
        assertEquals("New York", mutableCityInfo1City?.state)
        assertEquals("United States of America", cityInfo1City?.country)
        assertEquals("United States of America", mutableCityInfo1City?.country)
        //
        assertEquals("Capital of New York state", cityInfo1?.info)
        assertEquals("Capital of New York state", mutableCityInfo1?.info)
        //
        val cityInfo2 = model.modelRoot?.cityInfo?.elementAt(2)
        val mutableCityInfo2 = mutableModel.modelRoot?.cityInfo?.elementAt(2)
        ////
        val cityInfo2City = cityInfo2?.city
        val mutableCityInfo2City = mutableCityInfo2?.city
        assertEquals("Princeton", cityInfo2City?.name)
        assertEquals("Princeton", mutableCityInfo2City?.name)
        assertEquals("New Jersey", cityInfo2City?.state)
        assertEquals("New Jersey", mutableCityInfo2City?.state)
        assertEquals("United States of America", cityInfo2City?.country)
        assertEquals("United States of America", mutableCityInfo2City?.country)
        //
        assertEquals("Home of Princeton University", cityInfo2?.info)
        assertEquals("Home of Princeton University", mutableCityInfo2?.info)
        //
        val cityInfo3 = model.modelRoot?.cityInfo?.elementAt(3)
        val mutableCityInfo3 = mutableModel.modelRoot?.cityInfo?.elementAt(3)
        ////
        val cityInfo3City = cityInfo3?.city
        val mutableCityInfo3City = mutableCityInfo3?.city
        assertEquals("San Francisco", cityInfo3City?.name)
        assertEquals("San Francisco", mutableCityInfo3City?.name)
        assertEquals("California", cityInfo3City?.state)
        assertEquals("California", mutableCityInfo3City?.state)
        assertEquals("United States of America", cityInfo3City?.country)
        assertEquals("United States of America", mutableCityInfo3City?.country)
        //
        assertEquals("The cultural and financial center of Northern California", cityInfo3?.info)
        assertEquals("The cultural and financial center of Northern California", mutableCityInfo3?.info)

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

    @Test
    fun elements_in_decoded_model_must_be_readable_with_entity_set_keys() {
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
        val group0 = model.modelRoot?.groups("DC")
        val mutableGroup0 = mutableModel.modelRoot?.groups("DC")
        assertNotNull(group0)
        assertNotNull(mutableGroup0)
        assertEquals("DC", group0.name)
        assertEquals("DC", mutableGroup0.name)
        assertEquals(1, group0.subGroups?.count())
        assertEquals(1, mutableGroup0.subGroups?.count())
        ////
        val group0Subgroup0 = group0.subGroups("Superman")
        val mutableGroup0Subgroup0 = mutableGroup0.subGroups("Superman")
        assertNotNull(group0Subgroup0)
        assertNotNull(mutableGroup0Subgroup0)
        assertEquals("Superman", group0Subgroup0.name)
        assertEquals("Superman", mutableGroup0Subgroup0.name)
        //
        val group1 = model.modelRoot?.groups("Marvel")
        val mutableGroup1 = mutableModel.modelRoot?.groups("Marvel")
        assertNotNull(group1)
        assertNotNull(mutableGroup1)
        assertEquals("Marvel", group1.name)
        assertEquals("Marvel", mutableGroup1.name)

        assertEquals(2, model.modelRoot?.person?.count())
        assertEquals(2, mutableModel.modelRoot?.person?.count())
        //
        val person0 = model.modelRoot?.person("cc477201-48ec-4367-83a4-7fdbd92f8a6f")
        val mutablePerson0 = mutableModel.modelRoot?.person("cc477201-48ec-4367-83a4-7fdbd92f8a6f")
        assertNotNull(person0)
        assertNotNull(mutablePerson0)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", person0.id)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", mutablePerson0.id)
        assertEquals("Clark", person0.firstName)
        assertEquals("Clark", mutablePerson0.firstName)
        assertEquals("Kent", person0.lastName)
        assertEquals("Kent", mutablePerson0.lastName)
        assertEquals("Superman", person0.heroName)
        assertEquals("Superman", mutablePerson0.heroName)
        assertEquals("kryptonite", person0.password?.unhashed)
        assertEquals("kryptonite", mutablePerson0.password?.unhashed)
        assertEquals(null, person0.password?.hashed)
        assertEquals(null, mutablePerson0.password?.hashed)
        assertEquals(0, person0.password?.hashVersion)
        assertEquals(0, mutablePerson0.password?.hashVersion)
        assertEquals("Alien from Krypton", person0.mainSecret?.unencrypted)
        assertEquals("Alien from Krypton", mutablePerson0.mainSecret?.unencrypted)
        assertEquals(null, person0.mainSecret?.encrypted)
        assertEquals(null, mutablePerson0.mainSecret?.encrypted)
        assertEquals(0, person0.mainSecret?.cipherVersion)
        assertEquals(0, mutablePerson0.mainSecret?.cipherVersion)
        assertEquals(1, person0.relation?.count())
        assertEquals(1, mutablePerson0.relation?.count())
        ////
        val person0Relation0 = person0.relation("05ade278-4b44-43da-a0cc-14463854e397")
        val mutablePerson0Relation0 = mutablePerson0.relation("05ade278-4b44-43da-a0cc-14463854e397")
        assertNotNull(person0Relation0)
        assertNotNull(mutablePerson0Relation0)
        assertEquals("05ade278-4b44-43da-a0cc-14463854e397", person0Relation0.id)
        assertEquals("05ade278-4b44-43da-a0cc-14463854e397", mutablePerson0Relation0.id)
        assertEquals(AddressBookRelationship.COLLEAGUE, person0Relation0.relationship)
        assertEquals(AddressBookRelationship.COLLEAGUE, mutablePerson0Relation0.relationship)
        val person0Relation0Person = person0Relation0.person
        val mutablePerson0Relation0Person = mutablePerson0Relation0.person
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", person0Relation0Person?.person("a8aacf55-7810-4b43-afe5-4344f25435fd")?.id)
        assertEquals("a8aacf55-7810-4b43-afe5-4344f25435fd", mutablePerson0Relation0Person?.person("a8aacf55-7810-4b43-afe5-4344f25435fd")?.id)
        //
        val person0Group = person0.group
        val mutablePerson0Group = mutablePerson0.group
        assertNotNull(person0Group?.groups("DC")?.subGroups("Superman"))
        assertNotNull(mutablePerson0Group?.groups("DC")?.subGroups("Superman"))
        //
        val person1 = model.modelRoot?.person("a8aacf55-7810-4b43-afe5-4344f25435fd")
        val mutablePerson1 = mutableModel.modelRoot?.person("a8aacf55-7810-4b43-afe5-4344f25435fd")
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
        val person1Relation0 = person1?.relation("16634916-8f83-4376-ad42-37038e108a0b")
        val mutablePerson1Relation0 = mutablePerson1?.relation("16634916-8f83-4376-ad42-37038e108a0b")
        assertEquals("16634916-8f83-4376-ad42-37038e108a0b", person1Relation0?.id)
        assertEquals("16634916-8f83-4376-ad42-37038e108a0b", mutablePerson1Relation0?.id)
        assertEquals(AddressBookRelationship.COLLEAGUE, person1Relation0?.relationship)
        assertEquals(AddressBookRelationship.COLLEAGUE, mutablePerson1Relation0?.relationship)
        val person1Relation0Person = person1Relation0?.person
        val mutablePerson1Relation0Person = mutablePerson1Relation0?.person
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", person1Relation0Person?.person("cc477201-48ec-4367-83a4-7fdbd92f8a6f")?.id)
        assertEquals("cc477201-48ec-4367-83a4-7fdbd92f8a6f", mutablePerson1Relation0Person?.person("cc477201-48ec-4367-83a4-7fdbd92f8a6f")?.id)
        //
        val person1Group = person1?.group
        val mutablePerson1Group = mutablePerson1?.group
        assertNotNull(person1Group?.groups("DC")?.subGroups("Superman"))
        assertNotNull(mutablePerson1Group?.groups("DC")?.subGroups("Superman"))

        assertEquals(4, model.modelRoot?.cityInfo?.count())
        assertEquals(4, mutableModel.modelRoot?.cityInfo?.count())
        //
        val cityInfo0 = model.modelRoot?.cityInfo("New York City", "New York", "United States of America")
        val mutableCityInfo0 = mutableModel.modelRoot?.cityInfo("New York City", "New York", "United States of America")
        ////
        val cityInfo0City = cityInfo0?.city
        val mutableCityInfo0City = mutableCityInfo0?.city
        assertEquals("New York City", cityInfo0City?.name)
        assertEquals("New York City", mutableCityInfo0City?.name)
        assertEquals("New York", cityInfo0City?.state)
        assertEquals("New York", mutableCityInfo0City?.state)
        assertEquals("United States of America", cityInfo0City?.country)
        assertEquals("United States of America", mutableCityInfo0City?.country)
        //
        assertEquals("One of the most populous and most densely populated major city in USA", cityInfo0?.info)
        assertEquals("One of the most populous and most densely populated major city in USA", mutableCityInfo0?.info)
        //
        val cityInfo1 = model.modelRoot?.cityInfo("Albany", "New York", "United States of America")
        val mutableCityInfo1 = mutableModel.modelRoot?.cityInfo("Albany", "New York", "United States of America")
        ////
        val cityInfo1City = cityInfo1?.city
        val mutableCityInfo1City = mutableCityInfo1?.city
        assertEquals("Albany", cityInfo1City?.name)
        assertEquals("Albany", mutableCityInfo1City?.name)
        assertEquals("New York", cityInfo1City?.state)
        assertEquals("New York", mutableCityInfo1City?.state)
        assertEquals("United States of America", cityInfo1City?.country)
        assertEquals("United States of America", mutableCityInfo1City?.country)
        //
        assertEquals("Capital of New York state", cityInfo1?.info)
        assertEquals("Capital of New York state", mutableCityInfo1?.info)
        //
        val cityInfo2 = model.modelRoot?.cityInfo("Princeton", "New Jersey", "United States of America")
        val mutableCityInfo2 = mutableModel.modelRoot?.cityInfo("Princeton", "New Jersey", "United States of America")
        ////
        val cityInfo2City = cityInfo2?.city
        val mutableCityInfo2City = mutableCityInfo2?.city
        assertEquals("Princeton", cityInfo2City?.name)
        assertEquals("Princeton", mutableCityInfo2City?.name)
        assertEquals("New Jersey", cityInfo2City?.state)
        assertEquals("New Jersey", mutableCityInfo2City?.state)
        assertEquals("United States of America", cityInfo2City?.country)
        assertEquals("United States of America", mutableCityInfo2City?.country)
        //
        assertEquals("Home of Princeton University", cityInfo2?.info)
        assertEquals("Home of Princeton University", mutableCityInfo2?.info)
        //
        val cityInfo3 = model.modelRoot?.cityInfo("San Francisco", "California", "United States of America")
        val mutableCityInfo3 = mutableModel.modelRoot?.cityInfo("San Francisco", "California", "United States of America")
        ////
        val cityInfo3City = cityInfo3?.city
        val mutableCityInfo3City = mutableCityInfo3?.city
        assertEquals("San Francisco", cityInfo3City?.name)
        assertEquals("San Francisco", mutableCityInfo3City?.name)
        assertEquals("California", cityInfo3City?.state)
        assertEquals("California", mutableCityInfo3City?.state)
        assertEquals("United States of America", cityInfo3City?.country)
        assertEquals("United States of America", mutableCityInfo3City?.country)
        //
        assertEquals("The cultural and financial center of Northern California", cityInfo3?.info)
        assertEquals("The cultural and financial center of Northern California", mutableCityInfo3?.info)

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

    @Test
    fun json_encoding_of_model_built_with_dsl_must_be_correct() {
        val model = newAddressBookWithGeneratedClasses()
        assertMatchesJson(
            model,
            // TODO(deepak-nulu): verify aux encoding when the DSL supports aux data.
            "address_book_without_aux.json",
            EncodePasswords.ALL,
        )
    }
}