f = open("triplesSmall")
o = open("formattedTriplesLatest","w")
triples = []
dict1={}
for line in f:
	splitLine=line.split("\t")
	if(len(splitLine)<3):
		continue
	print len(splitLine)
	
	arg1=splitLine[0].replace("Template:","").replace("#####","").replace("<br />"," ").replace("<br/>"," ")
	rel=splitLine[1].replace("[[","").replace("]]","").replace("#####","").replace("<br />"," ").replace("<br/>"," ")
	#arg2=splitLine[2]
	list1=splitLine[2].split("*")
	for elem in list1:
		if elem=="" or elem==" " or "{{Navbox subgroup" in elem:
			continue
		elem1 = elem.replace("[[","").replace("]]","").replace("\'\'\'","").replace("#####","").replace("<br />"," ").replace("<br/>"," ")
		o.write(arg1+"\t"+rel+"\t"+elem1+"\n")
	
	

f.close()
o.close()
