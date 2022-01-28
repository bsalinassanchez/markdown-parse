#this file is meant to try to break MarkdownParse.java

First, lets make a normal link: [someLink](www.twitter.com) ok
Next, multiple links: [anotherLink](www.youtube.com),[andAnotherLink](www.reddit.com)

now even more multple links: [anotherLink](www.youtube.com),[andAnotherLink](www.reddit.com),[yetAnotherLink](www.somelink.com)

now, lets try some funny stuff:  [someSortOfLink]  (www.youtube.com)  *notice the space between ] and (*

an empty link: []()

a scrambled link: ] [ ) (

an unfinished link:  anotherLink](www.google.com)

how about: [something random] .   and then a [link](www.somesite.com);

