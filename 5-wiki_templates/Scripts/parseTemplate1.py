import xml.etree.ElementTree as ET
import re


tree = ET.parse('templates/allTemplatesNewer2.xml')
out = open("refinedValuesSmall","w")
out1 = open("nonRefinedValuesSmall","w")
out2 = open("attributeNamesSmall","w")
out3 = open("triplesSmall","w")
tupleArray = []
tupleArrayOrg = []
root = tree.getroot()
for child in root:
	titleTag = ""
	splitContent = []
	for grandchild in child:
		if grandchild.tag == "title":
			titleTag = grandchild.text
		if grandchild.tag == "text":
			content = grandchild.text
			content = content.replace("\n"," ")
			#if("{{Navbox" in content or "{{navbox" in content):
			if (True):
				splitContent = content.split("|")
				copySplitContent = []
				counter = 0
				ind = 0
				listVal = ""
				groupVal = ""
				indG = 0
				for contents in splitContent:
					m1 = re.compile('[\W]*group(?=[1-9][0-9]*)')
					m = re.compile('[\W]*list(?=[1-9][0-9]*)')
					if m.match(contents):
						#print contents
						ind = 1
						listVal = listVal + "@@@@@"+contents
						if(counter < len(splitContent) - 1 ):
							if("=" in splitContent[counter+1]):
								ind = 0
								copySplitContent.append(listVal)
								listVal = ""
						else:
							ind = 0
							copySplitContent.append(listVal)
							listVal = ""
					elif(ind ==1):
						listVal = listVal + "@@@@@"+ contents
						if(counter < len(splitContent) - 1):
							if("=" in splitContent[counter+1]):
								ind = 0
								copySplitContent.append(listVal)
								listVal = ""
						else:
							ind = 0
							copySplitContent.append(listVal)
							listVal = ""	
					#else:
						#copySplitContent.append(contents)
						
					#start matching for group contents
					
					if m1.match(contents):
						#print contents
						indG = 1
						groupVal = groupVal + "@@@@@"+contents
						
						if(counter < len(splitContent) - 1 ):
							if("=" in splitContent[counter+1]):
								indG = 0
								#print groupVal
								copySplitContent.append(groupVal)
								groupVal = ""
						else:
							indG = 0
							#print groupVal
							copySplitContent.append(groupVal)
							groupVal = ""
					elif(indG ==1):
						groupVal = groupVal + "@@@@@"+ contents
						if(counter < len(splitContent) - 1):
							if("=" in splitContent[counter+1]):
								indG = 0
								#print groupVal
								copySplitContent.append(groupVal)
								groupVal = ""
						else:
							indG = 0
							#print groupVal
							copySplitContent.append(groupVal)
							groupVal = ""	
					#else:
						#copySplitContent.append(contents)
					counter = counter + 1
				
				tup1 = (titleTag, copySplitContent)
				tup2 = (titleTag, splitContent)
				tupleArray.append(tup1)
				tupleArrayOrg.append(tup2)	
#print copySplitContent			
for entries in tupleArray:
	flag = False
	out.write(entries[0].encode('utf-8'))
	out.write("\n")
	index = 0
	while(index < len(entries[1])):
		element = entries[1][index]
		attributeName = ""
		valuesName = ""
		m = re.compile('[\W]*group(?=[1-9][0-9]*)')
		if(m.match(element)):
			#print element
			attributeName = element.split("=")
			if(len(attributeName)>1):
				out2.write(attributeName[1].encode('utf-8')+"\n")
				m1 = re.compile('[\W]*list(?=[1-9][0-9]*)')
				while(not m1.match(entries[1][index])):
					index = index + 1
					if(index >= len(entries[1])):
						flag = True
						break
				if(flag == False):
					valuesNames = entries[1][index].split("=")
					#print valuesNames
					if(len(valuesNames)>1):
						out3.write(entries[0].encode('utf-8'))
						out3.write("#####\t")
						out3.write(attributeName[1].encode('utf-8'))
						out3.write("#####\t")
						out3.write(valuesNames[1].encode('utf-8'))
						out3.write("#####\n")
		out.write(element.encode('utf-8'))
		out.write("\n")
		index = index + 1
	out.write("\n")
for entries in tupleArrayOrg:
	out1.write(entries[0].encode('utf-8'))
	out1.write("\n")
	for element in entries[1]:
		out1.write(element.encode('utf-8'))
		out1.write("\n")
	out1.write("\n")
#for entries in tupleArray:
	
