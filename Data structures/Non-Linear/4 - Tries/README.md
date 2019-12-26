# Tries (digital, radix or prefix)

- Another kind of trees, which are very powerful implementing auto completion.
- They're not **binary trees** because of each child can have several nodes.
- Provide super fast lookups.
- We do not waste storage, since words with the same prefix share the same nodes. For example, if we created an array to store it, we would waste memory storing the same prefix for every word.

## Operations

- **Lookup**: O(L), L corresponds to the length of the word
- **Insert**: O(L)
- **Delete**: O(L)

# Notes

- Implementing a trie using arrays, could waste a lot of memory. We can have nodes wasting memory with null values. To solve this problem, we could use an Hash table.

# Transversing a Trie

- Pre-Order: We visit each node first, before visit his children
- Post-Order: We go deep in the trie and then we come back up.