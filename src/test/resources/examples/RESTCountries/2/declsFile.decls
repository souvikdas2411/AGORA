decl-version 2.0
var-comparability implicit

ppt /name/{name}:::CLASS
ppt-type class

ppt /name/{name}&v3Name&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type v3Name&Input
	rep-type hashcode
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /name/{name}&v3Name&404():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type v3Name&Input
	rep-type hashcode
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /name/{name}&v3Name&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type v3Name&Input
	rep-type hashcode
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type v3Name&Output&200
	rep-type hashcode
variable return.name
	var-kind field name
	enclosing-var return
	dec-type v3Name&Output&200&name
	rep-type hashcode
variable return.name.common
	var-kind field common
	enclosing-var return.name
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name.official
	var-kind field official
	enclosing-var return.name
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name.nativeName
	var-kind field nativeName
	enclosing-var return.name
	dec-type v3Name&Output&200&nativeName
	rep-type hashcode
variable return.name.nativeName.deu
	var-kind field deu
	enclosing-var return.name.nativeName
	dec-type v3Name&Output&200&deu
	rep-type hashcode
variable return.name.nativeName.deu.official
	var-kind field official
	enclosing-var return.name.nativeName.deu
	dec-type java.lang.String
	rep-type java.lang.String
variable return.name.nativeName.deu.common
	var-kind field common
	enclosing-var return.name.nativeName.deu
	dec-type java.lang.String
	rep-type java.lang.String
variable return.tld
	var-kind field tld
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.tld[..]
	var-kind array
	enclosing-var return.tld
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.cca2
	var-kind field cca2
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.ccn3
	var-kind field ccn3
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.cca3
	var-kind field cca3
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.cioc
	var-kind field cioc
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.independent
	var-kind field independent
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.status
	var-kind field status
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.unMember
	var-kind field unMember
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.currencies
	var-kind field currencies
	enclosing-var return
	dec-type v3Name&Output&200&currencies
	rep-type hashcode
variable return.currencies.EUR
	var-kind field EUR
	enclosing-var return.currencies
	dec-type v3Name&Output&200&EUR
	rep-type hashcode
variable return.currencies.EUR.name
	var-kind field name
	enclosing-var return.currencies.EUR
	dec-type java.lang.String
	rep-type java.lang.String
variable return.currencies.EUR.symbol
	var-kind field symbol
	enclosing-var return.currencies.EUR
	dec-type java.lang.String
	rep-type java.lang.String
variable return.idd
	var-kind field idd
	enclosing-var return
	dec-type v3Name&Output&200&idd
	rep-type hashcode
variable return.idd.root
	var-kind field root
	enclosing-var return.idd
	dec-type java.lang.String
	rep-type java.lang.String
variable return.idd.suffixes
	var-kind field suffixes
	enclosing-var return.idd
	dec-type java.lang.String[]
	rep-type hashcode
variable return.idd.suffixes[..]
	var-kind array
	enclosing-var return.idd.suffixes
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.capital
	var-kind field capital
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.capital[..]
	var-kind array
	enclosing-var return.capital
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.altSpellings
	var-kind field altSpellings
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.altSpellings[..]
	var-kind array
	enclosing-var return.altSpellings
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.region
	var-kind field region
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.subregion
	var-kind field subregion
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.languages
	var-kind field languages
	enclosing-var return
	dec-type v3Name&Output&200&languages
	rep-type hashcode
variable return.languages.deu
	var-kind field deu
	enclosing-var return.languages
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations
	var-kind field translations
	enclosing-var return
	dec-type v3Name&Output&200&translations
	rep-type hashcode
variable return.translations.ara
	var-kind field ara
	enclosing-var return.translations
	dec-type v3Name&Output&200&ara
	rep-type hashcode
variable return.translations.ara.official
	var-kind field official
	enclosing-var return.translations.ara
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.ara.common
	var-kind field common
	enclosing-var return.translations.ara
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.bre
	var-kind field bre
	enclosing-var return.translations
	dec-type v3Name&Output&200&bre
	rep-type hashcode
variable return.translations.bre.official
	var-kind field official
	enclosing-var return.translations.bre
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.bre.common
	var-kind field common
	enclosing-var return.translations.bre
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.ces
	var-kind field ces
	enclosing-var return.translations
	dec-type v3Name&Output&200&ces
	rep-type hashcode
variable return.translations.ces.official
	var-kind field official
	enclosing-var return.translations.ces
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.ces.common
	var-kind field common
	enclosing-var return.translations.ces
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.cym
	var-kind field cym
	enclosing-var return.translations
	dec-type v3Name&Output&200&cym
	rep-type hashcode
variable return.translations.cym.official
	var-kind field official
	enclosing-var return.translations.cym
	dec-type java.lang.String
	rep-type java.lang.String
variable return.translations.cym.common
	var-kind field common
	enclosing-var return.translations.cym
	dec-type java.lang.String
	rep-type java.lang.String
variable return.latlng
	var-kind field latlng
	enclosing-var return
	dec-type double[]
	rep-type hashcode
variable return.latlng[..]
	var-kind array
	enclosing-var return.latlng
	array 1
	dec-type double[]
	rep-type double[]
variable return.landlocked
	var-kind field landlocked
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.borders
	var-kind field borders
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.borders[..]
	var-kind array
	enclosing-var return.borders
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.area
	var-kind field area
	enclosing-var return
	dec-type double
	rep-type double
variable return.demonyms
	var-kind field demonyms
	enclosing-var return
	dec-type v3Name&Output&200&demonyms
	rep-type hashcode
variable return.demonyms.eng
	var-kind field eng
	enclosing-var return.demonyms
	dec-type v3Name&Output&200&eng
	rep-type hashcode
variable return.demonyms.eng.f
	var-kind field f
	enclosing-var return.demonyms.eng
	dec-type java.lang.String
	rep-type java.lang.String
variable return.demonyms.eng.m
	var-kind field m
	enclosing-var return.demonyms.eng
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flag
	var-kind field flag
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.maps
	var-kind field maps
	enclosing-var return
	dec-type v3Name&Output&200&maps
	rep-type hashcode
variable return.maps.googleMaps
	var-kind field googleMaps
	enclosing-var return.maps
	dec-type java.lang.String
	rep-type java.lang.String
variable return.maps.openStreetMaps
	var-kind field openStreetMaps
	enclosing-var return.maps
	dec-type java.lang.String
	rep-type java.lang.String
variable return.population
	var-kind field population
	enclosing-var return
	dec-type double
	rep-type double
variable return.gini
	var-kind field gini
	enclosing-var return
	dec-type v3Name&Output&200&gini
	rep-type hashcode
variable return.gini.2016
	var-kind field 2016
	enclosing-var return.gini
	dec-type double
	rep-type double
variable return.fifa
	var-kind field fifa
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.car
	var-kind field car
	enclosing-var return
	dec-type v3Name&Output&200&car
	rep-type hashcode
variable return.car.signs
	var-kind field signs
	enclosing-var return.car
	dec-type java.lang.String[]
	rep-type hashcode
variable return.car.signs[..]
	var-kind array
	enclosing-var return.car.signs
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.car.side
	var-kind field side
	enclosing-var return.car
	dec-type java.lang.String
	rep-type java.lang.String
variable return.timezones
	var-kind field timezones
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.timezones[..]
	var-kind array
	enclosing-var return.timezones
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.continents
	var-kind field continents
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.continents[..]
	var-kind array
	enclosing-var return.continents
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.flags
	var-kind field flags
	enclosing-var return
	dec-type v3Name&Output&200&flags
	rep-type hashcode
variable return.flags.png
	var-kind field png
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flags.svg
	var-kind field svg
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.flags.alt
	var-kind field alt
	enclosing-var return.flags
	dec-type java.lang.String
	rep-type java.lang.String
variable return.coatOfArms
	var-kind field coatOfArms
	enclosing-var return
	dec-type v3Name&Output&200&coatOfArms
	rep-type hashcode
variable return.coatOfArms.png
	var-kind field png
	enclosing-var return.coatOfArms
	dec-type java.lang.String
	rep-type java.lang.String
variable return.coatOfArms.svg
	var-kind field svg
	enclosing-var return.coatOfArms
	dec-type java.lang.String
	rep-type java.lang.String
variable return.startOfWeek
	var-kind field startOfWeek
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.capitalInfo
	var-kind field capitalInfo
	enclosing-var return
	dec-type v3Name&Output&200&capitalInfo
	rep-type hashcode
variable return.capitalInfo.latlng
	var-kind field latlng
	enclosing-var return.capitalInfo
	dec-type double[]
	rep-type hashcode
variable return.capitalInfo.latlng[..]
	var-kind array
	enclosing-var return.capitalInfo.latlng
	array 1
	dec-type double[]
	rep-type double[]
variable return.postalCode
	var-kind field postalCode
	enclosing-var return
	dec-type v3Name&Output&200&postalCode
	rep-type hashcode
variable return.postalCode.format
	var-kind field format
	enclosing-var return.postalCode
	dec-type java.lang.String
	rep-type java.lang.String
variable return.postalCode.regex
	var-kind field regex
	enclosing-var return.postalCode
	dec-type java.lang.String
	rep-type java.lang.String

ppt /name/{name}&v3Name&404():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type v3Name&Input
	rep-type hashcode
variable input.name
	var-kind field name
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type v3Name&Output&404
	rep-type hashcode
variable return.status
	var-kind field status
	enclosing-var return
	dec-type int
	rep-type int
variable return.message
	var-kind field message
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

