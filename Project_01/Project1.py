#Project 1
#Name: Wing Yi Wong


class Random:
    
    def __init__(self, seed): #Park Miller generator with seed as range
        self.seed = (16807 * seed) % (2147483648 - 1)

    def next(self, range):  #generate the next term in sequence

        self.seed = (16807 * self.seed) % (2147483648 - 1)
        return self.seed % range
        
    def choose(self, objects):  #choose an element from the list objects at random

        L = objects
        return L[self.next(len(L))]

class Nonce:
    
    def __init__(self, seed):

        self.first = []  #list of letters and initally empty
        self.follow = {} #dictionary whose keys and letter and values are lists of letters

        if (seed >= 1) and (seed <= (2**31)-2):     #range must be between 1 and 2³¹ − 2
            self.random = Random(seed)
        else:
            raise Exception

    def add(self, word):

        self.first = self.first +[word[0]]  #add first letter of word into list self.first

        if (len(word) > 1):

           for i in range(0, len(word)-1):
                if (word[i] in self.follow):
                    self.follow[word[i]].append(word[i+1])  #add value to associated key to dictionary
                else:   
                    self.follow[word[i]] = [word[i+1]]      #add new key and value to dictionary 

        return None

    def make(self, size):
        if (size > 0):
            newWord = self.random.choose(self.first)    #choose a random letter from list first
            letter = self.random.choose(self.follow[newWord[len(newWord)-1]])       
                   
            while (len(newWord) < size):

                newWord = newWord + letter
            
                if (letter in self.follow):     #if letter is one of the key, generate next random letter from its value
                    letter = self.random.choose(self.follow[newWord[len(newWord)-1]])               
                else:
                    letter = self.random.choose(self.first)     #else choose a letter from the list first
            
            return newWord

        elif (size == 0):
            print('Size is 0. Cannot make the word.')

        else:
            raise Exception                  

##########################################################################################################
#Result:

#>>> nw = Nonce(101)
#>>> nw.add('ada')
#>>> nw.add('algol')
#>>> nw.add('bliss')
#>>> nw.add('ceylon')
#>>> nw.add('clojure')
#>>> nw.add('curl')  
#>>> nw.add('dart')
#>>> nw.add('eiffel')
#>>> nw.add('elephant')
#>>> nw.add('elisp')
#>>> nw.add('falcon')
#>>> nw.add('fortran')
#>>> nw.add('go')
#>>> nw.add('groovy')
#>>> nw.add('haskell')
#>>> nw.add('heron')
#>>> nw.add('intercal')
#>>> nw.add('java')
#>>> nw.add('javascript')
#>>> nw.add('latex')
#>>> nw.add('lisp')
#>>> nw.add('mathematica')
#>>> nw.add('nice')
#>>> nw.add('oak')
#>>> nw.add('occam')
#>>> nw.add('orson')
#>>> nw.add('pascal')  
#>>> nw.add('postscript')
#>>> nw.add('prolog')
#>>> nw.add('python')
#>>> nw.add('ruby')
#>>> nw.add('scala')
#>>> nw.add('scheme')
#>>> nw.add('self')
#>>> nw.add('snobol')
#>>> nw.add('swift')
#>>> nw.add('tex')
#>>> nw.add('wolfram')
#>>> nw.make(6)
#'iffont'
#>>> nw.make(6)
#'erifei'
#>>> nw.make(6)
#'javyli'
#>>> nw.make(6)
#'eliske'
#>>> nw.make(6)
#'wipame'


#>>> nw.make(0)
#Size is 0. Cannot make the word.


#>>> n = Nonce(0)
#Traceback (most recent call last):
#  File "<pyshell#49>", line 1, in <module>
#    n = Nonce(0)
#  File "/Users/Pinki/Desktop/python/project1.py", line 30, in __init__
#    raise Exception
#Exception
