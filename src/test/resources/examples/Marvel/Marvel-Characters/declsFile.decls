decl-version 2.0
var-comparability implicit

ppt /characters/{characterId}:::CLASS
ppt-type class

ppt /characters/{characterId}&characterId&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type characterId&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /characters/{characterId}&characterId&200&data&results():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type characterId&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /characters/{characterId}&characterId&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type characterId&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type characterId&Output&200
	rep-type hashcode
variable return.data
	var-kind field data
	enclosing-var return
	dec-type characterId&Output&200&data
	rep-type hashcode
variable return.data.offset
	var-kind field offset
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.limit
	var-kind field limit
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.total
	var-kind field total
	enclosing-var return.data
	dec-type int
	rep-type int
variable return.data.count
	var-kind field count
	enclosing-var return.data
	dec-type int
	rep-type int
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

ppt /characters/{characterId}&characterId&200&data&results():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type characterId&Input
	rep-type hashcode
variable input.characterId
	var-kind field characterId
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type characterId&Output&200&data&results
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.name
	var-kind field name
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String

