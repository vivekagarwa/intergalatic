I have uploaded a eclipse project, which is configured by using maven.

The two important tools that should be installed on a system to open this project in eclipse are 
1) Maven
2) Google Protocol Buffers (It can be downloaded from here:http://code.google.com/p/protobuf/downloads/detail?name=protobuf-2.5.0.zip)

pom.xml is specified in the folder in which all additional dependencies have been specified.
Installing "Google Protocol Buffers" is neccessary if one wishes to generate the protocol buffers file. Although the generated files are already present in the folder "target/generated-sources". But if one executes the maven command then these files are generated again in the process of building the project, and if "Google Protocol Buffers" (protoc) is not installed then the build will fail.

I have not used jUnit before but have attempted to write some jUnit Test cases which are also run during the maven build. SampleTestCase runs for the sample input data. RomanParserAndValidatorTest runs some test on conversion of romanString to decimal.

Design:
The objects in the solution are as follows:
1) In file romanFile.proto - RomanLiteral, CompositeRomanLiteral, RomanString
2) In intergalaticUnitFile.proto - IntergalaticLiteral, IntergalaticString
3) In intergalaticUnitToRomanFile.proto - IntergalaticToRomanConversion
4) In commodityPriceFile.proto - Commodity, CommodityPrice
5) In commodityPriceQueryFile.proto - CommodityPriceQuery, CommodityPriceResponse
6) In intergalaticUnitQueryFile.proto - IntergalaticUnitQuery, IntergalaticUnitResponse

There are two languages involved - Roman and Intergalatic. Each language has its literals and Strings.
Roman:
Literals for Roman are defined as RomanLiteral. A wrapper of this created as RomanLiteralEnum, which provides some additional functionality.
RulesConfig has rules defined for RomanLanguage. RomanString are sequence of CompositeRomanLiteral. 
CompositeRomanLiteral consists fo two roman literal and was created to handle peculiar case of subtraction in RomanLanguage, e.g - IV -> (5-1=4).

Intergalatic:
IntergalaticLiterals.java contains a collection that holds all the IntergalaticLiterals that are defined.
IntergalaticUnitToRomanConversionRules.java contains all the conversions of IntergalaticLiteral to Roman Literal. IntergalaticToRomanConversion defined in intergalaticUnitToRomanFile.proto is used to store one such conversion.
IntergalaticUnitToRomanParser creates a IntergalaticToRomanConversion, which is then passed to IntergalaticUnitToRomanHandler.
IntergalaticUnitToRomanHandler adds the new IntergalaticLiteral to IntergalaticLiterals and IntergalaticToRomanConversion to IntergalaticUnitToRomanConversionRules.

Commodity: It is used to store the commodity (e.g. Silver, Gold, Iron)
CommodityPrice : It is used to store the commodityPrice for a 1 unit of commodity (e.g. Silver, Gold, Iron)
CommodityLiterals store all commodities, while CommodityPricing stores price of all commmodities.
CommodityPriceParser parses the data and creates CommodityPrice, which is passed to CommodityPriceHandler.
CommodityPriceHandler adds Commodity to CommodityLiterals and CommodityPrice to CommodityPricing.

IntergalaticUnitQuery & IntergalaticUnitResponse are for the query of type inquring about interagalaticString to their decimal representation.
CommodityPriceQuery & CommodityPriceResponse are for the query of type inquring about commodityPrice.

In general - parser are used to parse the incoming data. If parser is not able to successfully parse the data it returns null.
The parsed data is send to handler which takes the neccessary action. In case of queries they returns the final string to be outputted.


