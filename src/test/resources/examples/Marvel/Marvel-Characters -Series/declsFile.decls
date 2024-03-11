decl-version 2.0
var-comparability implicit

ppt /characters/{characterId}/series:::CLASS
ppt-type class

ppt /characters/{characterId}/series&characterId/series&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type characterId/series&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.title
	var-kind field title
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.titleStartsWith
	var-kind field titleStartsWith
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.startYear
	var-kind field startYear
	enclosing-var input
	dec-type int
	rep-type int
variable input.modifiedSince
	var-kind field modifiedSince
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.comics
	var-kind field comics
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.stories
	var-kind field stories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.events
	var-kind field events
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.creators
	var-kind field creators
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.seriesType
	var-kind field seriesType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.contains
	var-kind field contains
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.orderBy
	var-kind field orderBy
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /characters/{characterId}/series&characterId/series&200&data&results():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type characterId/series&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.title
	var-kind field title
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.titleStartsWith
	var-kind field titleStartsWith
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.startYear
	var-kind field startYear
	enclosing-var input
	dec-type int
	rep-type int
variable input.modifiedSince
	var-kind field modifiedSince
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.comics
	var-kind field comics
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.stories
	var-kind field stories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.events
	var-kind field events
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.creators
	var-kind field creators
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.seriesType
	var-kind field seriesType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.contains
	var-kind field contains
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.orderBy
	var-kind field orderBy
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int

ppt /characters/{characterId}/series&characterId/series&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type characterId/series&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.title
	var-kind field title
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.titleStartsWith
	var-kind field titleStartsWith
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.startYear
	var-kind field startYear
	enclosing-var input
	dec-type int
	rep-type int
variable input.modifiedSince
	var-kind field modifiedSince
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.comics
	var-kind field comics
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.stories
	var-kind field stories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.events
	var-kind field events
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.creators
	var-kind field creators
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.seriesType
	var-kind field seriesType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.contains
	var-kind field contains
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.orderBy
	var-kind field orderBy
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type characterId/series&Output&200
	rep-type hashcode
variable return.data
	var-kind field data
	enclosing-var return
	dec-type characterId/series&Output&200&data
	rep-type hashcode
variable return.data.results
	var-kind field results
	enclosing-var return.data
	dec-type results[]
	rep-type hashcode
variable return.data.results[..]
	var-kind array
	enclosing-var return.data.results
	array 1
	dec-type results[]
	rep-type hashcode[]

ppt /characters/{characterId}/series&characterId/series&200&data&results():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type characterId/series&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.title
	var-kind field title
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.titleStartsWith
	var-kind field titleStartsWith
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.startYear
	var-kind field startYear
	enclosing-var input
	dec-type int
	rep-type int
variable input.modifiedSince
	var-kind field modifiedSince
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.comics
	var-kind field comics
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.stories
	var-kind field stories
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.events
	var-kind field events
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.creators
	var-kind field creators
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.seriesType
	var-kind field seriesType
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.contains
	var-kind field contains
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.orderBy
	var-kind field orderBy
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.offset
	var-kind field offset
	enclosing-var input
	dec-type int
	rep-type int
variable return
	var-kind return
	dec-type characterId/series&Output&200&data&results
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.title
	var-kind field title
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.startYear
	var-kind field startYear
	enclosing-var return
	dec-type int
	rep-type int
variable return.endYear
	var-kind field endYear
	enclosing-var return
	dec-type int
	rep-type int
variable return.rating
	var-kind field rating
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

