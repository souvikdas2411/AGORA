decl-version 2.0
var-comparability implicit

ppt /owners:::CLASS
ppt-type class

ppt /owners&/owners&post&201():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type /owners&post&Input
	rep-type hashcode
variable input.firstName
	var-kind field firstName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.lastName
	var-kind field lastName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.address
	var-kind field address
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.city
	var-kind field city
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.telephone
	var-kind field telephone
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /owners&/owners&post&201&pets():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type /owners&post&Input
	rep-type hashcode
variable input.firstName
	var-kind field firstName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.lastName
	var-kind field lastName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.address
	var-kind field address
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.city
	var-kind field city
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.telephone
	var-kind field telephone
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /owners&/owners&post&201():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type /owners&post&Input
	rep-type hashcode
variable input.firstName
	var-kind field firstName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.lastName
	var-kind field lastName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.address
	var-kind field address
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.city
	var-kind field city
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.telephone
	var-kind field telephone
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type /owners&post&Output&201
	rep-type hashcode
variable return.id
	var-kind field id
	enclosing-var return
	dec-type int
	rep-type int
variable return.firstName
	var-kind field firstName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.lastName
	var-kind field lastName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.address
	var-kind field address
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.city
	var-kind field city
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.telephone
	var-kind field telephone
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.pets
	var-kind field pets
	enclosing-var return
	dec-type pets[]
	rep-type hashcode
variable return.pets[..]
	var-kind array
	enclosing-var return.pets
	array 1
	dec-type pets[]
	rep-type hashcode[]

ppt /owners&/owners&post&201&pets():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type /owners&post&Input
	rep-type hashcode
variable input.firstName
	var-kind field firstName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.lastName
	var-kind field lastName
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.address
	var-kind field address
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.city
	var-kind field city
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.telephone
	var-kind field telephone
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type /owners&post&Output&201&pets
	rep-type hashcode

