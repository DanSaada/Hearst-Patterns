# Hearst-Patterns

**A preview -** Hypernymy (also called IS-A relation) is a semantic relation between two noun phrases, hypernym and hyponym, such that the hyponym is a subtype of the hypernym. For example, cat and dog are hyponym of animal because they are types of animals. Hypernym relations are hierarchical, so a word can have multiple hypernyms. For example, dog is a hyponym of animal, canine and mammal.

**Project description -** In this project there are two part: Creating a Hypernym-Relations database and discovering a lemma(hypernym) in the Hypernym-Relations database.

- In the first part, the program reads all the files in the given directory path, finds and extracts hypernym relations that match the Hearst patterns using regular expressions, and save them in a txt file at the given output path.
- In the second part, the program searches all the possible hypernyms of the input lemma and prints them and their number of appearances to the console.
