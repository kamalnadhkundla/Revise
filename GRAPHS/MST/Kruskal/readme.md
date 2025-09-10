Disjoint set is a collection of sets where no two sets have any elements in common.
Basically you will be given some edges from the edges you will have some groups of nodes.
but while building the groups probably you might be asked that any 2 elements are from the same group then you return TRUE/FALSE in the constant term.
previously you could have used dfs or bfs and say True/False but this is gonna take a lot of time.
Basically disjoint set can be done via rank/size.
and have 2 main functionalites : findparent() // to find the extreme parent and union()// to merge 2 groups
