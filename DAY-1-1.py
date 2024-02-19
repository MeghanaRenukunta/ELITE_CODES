'''
There are N rooms in a row, and all the rooms are locked initially.
You will be provided the master key. You can use the master key only once, and
you can unlock any one room and find a key in it of some other room. 
You have to repeat this process until you can find the keys of the locked rooms. 
You have to stop this process once you find the key of a room 
which is already unlocked.

You are given an array of keys[], where i-th room contains the key of key[i]-th
room and values of keys[] are range from [0..N-1] without duplicates. Your task 
is to find the maximum number of rooms can be unlocked including the first room.

Input Format:
-------------
Line-1: An integer N, number of rooms.
Line-2: N space separated integers, keys of rooms.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
8
7 4 6 2 1 0 3 5

Sample Output-1:
----------------
3

Explanation:
-----------
keys[0] = 7, keys[1] = 4, keys[2] = 6, keys[3] = 2, keys[4] = 1, keys[5] = 0, 
keys[6] = 3, keys[7]=5.

You can start with Room-0 using the master key, you can open the following rooms:
key[0]=7 =>  key[7]=5  =>  key[5]=0
      or
key[2]=6 =>  key[6]=3  =>  key[3]=2

You can unlock maximum 3 rooms.

Sample Input-2:
---------------
6
3 2 4 0 5 1

Sample Output-2:
----------------
4

Sample Input-3:
---------------
5
0 1 2 3 4

Sample Output-3:
----------------
1


----------------------------
Write your Python code below
----------------------------
'''
n=int(input())
l=list(map(int,input().split()))
r=[]
for i in range(len(l)):
    b=[False]*n
    c=0
    x=l[i]                                                          
    while(True):
        if(b[x]==False):
            b[x]=True
            x=l[x]
            c+=1
        elif(b[x]==True):
            r.append(c)
            break
print(max(r))



# # Python3 program to implement Disjoint Set Data
# # Structure.

# class DisjSet:
# 	def __init__(self, n):
# 		# Constructor to create and
# 		# initialize sets of n items
# 		self.rank = [1] * n
# 		self.parent = [i for i in range(n)]


# 	# Finds set of given item x
# 	def find(self, x):
		
# 		# Finds the representative of the set
# 		# that x is an element of
# 		if (self.parent[x] != x):
			
# 			# if x is not the parent of itself
# 			# Then x is not the representative of
# 			# its set,
# 			self.parent[x] = self.find(self.parent[x])
			
# 			# so we recursively call Find on its parent
# 			# and move i's node directly under the
# 			# representative of this set

# 		return self.parent[x]


# 	# Do union of two sets represented
# 	# by x and y.
# 	def Union(self, x, y):
		
# 		# Find current sets of x and y
# 		xset = self.find(x)
# 		yset = self.find(y)

# 		# If they are already in same set
# 		if xset == yset:
# 			return

# 		# Put smaller ranked item under
# 		# bigger ranked item if ranks are
# 		# different
# 		if self.rank[xset] < self.rank[yset]:
# 			self.parent[xset] = yset

# 		elif self.rank[xset] > self.rank[yset]:
# 			self.parent[yset] = xset

# 		# If ranks are same, then move y under
# 		# x (doesn't matter which one goes where)
# 		# and increment rank of x's tree
# 		else:
# 			self.parent[yset] = xset
# 			self.rank[xset] = self.rank[xset] + 1

# # Driver code
# n=int(input())
# obj = DisjSet(n)
# l=list(map(int,input().split()))
# for i in range(len(l)):
# 	obj.Union(i,l[i])
# r=[]
# for i in range(len(l)):
#     c=0 
#     for j in range(i,len(l)):
#         if obj.find(l[i])==obj.find(l[j]):
#             c+=1
#             r.append(c)
#             break
#         else:
#             c+=1
# print(r)
	
