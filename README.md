# TechKnowBase
README:

1.APPROACH : IMPROVING SEED LIST

a.Input: pagesOnlyTechnical (intersection of Wikipedia pages and SO tags)

b.Extract names of concepts from petscan
Input:petScan_TC (Downloaded from http://petscan.wmflabs.org/ by putting category as: computing and computer science; number of jumps=3)
Script: FilteringPetScanInput.java
Output: petScan_TC_OnlyTitles

c.Intersection of two lists
Input: pagesOnlyTechnical & petScan_TC_OnlyTitles
Script: MergingTwoLists
Output: MergedList_TC

d. Checking types of concepts with the help of YAGO
Input: MergedListOfTC
Script: RefiningListsUsingYagoTypes.java
Output: MergedListOfTC



2.APPROACH : USING CATEGORY SYSTEM OF WIKIPEDIA

a.Page categories:
Extracting relation from page categories
Input: pageCategoriesForTechnicalConcepts
Script: PlingStemmer_final1
Output: Relation3

b.Category’s Hierarchy system
i.Extracting subClassOf and subFieldOf from category hierarchy
Input: categoryAndTheirSubcategories
Script: PlingStemmer_final
Ouput: subClassOf and subFieldOf





3.APPROACH : USING TEMPLATE BOXES

a.Generate text dump:
Input: smallTemplate.xml
Script: 1. wikiExtractor.py
2. ExtractTechnicalText.java
3. parseTemplate1.py
4. formatTriples.py
Output: formattedTriplesLatest

b.Extracting all kinds of triples from templates (except unrequired relations like: see also, related articles etc)
Input: formattedTriplesLatest and MergedList_TC
Script: ExtractingTriplesFromTemplates.java
Output: SievedTemplates1

c.Extracting specific relations from text
Input: SievedTemplates1
Script: FindingSpecificRelations.java
Output: <Name of relation extracted>Relation



4.APPROACH : Extracting Patterns from the text

a.Breaking text into sentences.
Input: MergedListOfTC and MergedList_TC
Script: SubFieldOfRelations1.java
Output: TextIntoSentences

b.Coding different patterns separately, like:
Input: TextIntoSentences
Script: HearstPattern_isA.java
Output: HearstPattern_isA






