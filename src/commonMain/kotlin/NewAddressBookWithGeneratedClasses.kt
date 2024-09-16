import org.treeWare.test.addressBook.addressBook
import org.treeWare.test.addressBook.main.AddressBookColor
import org.treeWare.test.addressBook.main.AddressBookRelationship
import org.treeWare.test.addressBook.main.MutableAddressBookRoot

fun newAddressBookWithGeneratedClasses(): MutableAddressBookRoot = addressBook {
    name = "Address Book"
    lastUpdated = 1587147731UL
    settings {
        lastNameFirst = true
        encryptHeroName = false
        backgroundColor = AddressBookColor.WHITE
        advanced {
            borderColor = AddressBookColor.VIOLET
        }
    }
    groups {
        group {
            name = "DC"
            subGroups {
                group {
                    name = "Superman"
                }
            }
        }
        group {
            name = "Marvel"
        }
    }
    person {
        addressBookPerson {
            id = "cc477201-48ec-4367-83a4-7fdbd92f8a6f"
            firstName = "Clark"
            lastName = "Kent"
            heroName = "Superman"
            password {
                unhashed = "kryptonite"
            }
            mainSecret {
                unencrypted = "Alien from Krypton"
            }
            relation {
                addressBookRelation {
                    id = "05ade278-4b44-43da-a0cc-14463854e397"
                    relationship = AddressBookRelationship.COLLEAGUE
                    person {
                        person {
                            addressBookPerson {
                                id = "a8aacf55-7810-4b43-afe5-4344f25435fd"
                            }
                        }
                    }
                }
            }
            group {
                groups {
                    group {
                        name = "DC"
                        subGroups {
                            group {
                                name = "Superman"
                            }
                        }
                    }
                }
            }
        }
        addressBookPerson {
            id = "a8aacf55-7810-4b43-afe5-4344f25435fd"
            firstName = "Lois"
            lastName = "Lane"
            password {
                hashed = "test-hashed-lois"
                hashVersion = 1
            }
            mainSecret {
                encrypted = "test-encrypted-main-secret"
                cipherVersion = 1
            }
            relation {
                addressBookRelation {
                    id = "16634916-8f83-4376-ad42-37038e108a0b"
                    relationship = AddressBookRelationship.COLLEAGUE
                    person {
                        person {
                            addressBookPerson {
                                id = "cc477201-48ec-4367-83a4-7fdbd92f8a6f"
                            }
                        }
                    }
                }
            }
            group {
                groups {
                    group {
                        name = "DC"
                        subGroups {
                            group {
                                name = "Superman"
                            }
                        }
                    }
                }
            }
        }
    }
    cityInfo {
        addressBookCityInfo {
            city {
                name = "New York City"
                state = "New York"
                country = "United States of America"
            }
            info = "One of the most populous and most densely populated major city in USA"
        }
        addressBookCityInfo {
            info = "Capital of New York state"
            city {
                name = "Albany"
                state = "New York"
                country = "United States of America"
            }
        }
        addressBookCityInfo {
            info = "Home of Princeton University"
            city {
                name = "Princeton"
                state = "New Jersey"
                country = "United States of America"
            }
        }
        addressBookCityInfo {
            info = "The cultural and financial center of Northern California"
            city {
                name = "San Francisco"
                state = "California"
                country = "United States of America"
            }
        }
    }
}
