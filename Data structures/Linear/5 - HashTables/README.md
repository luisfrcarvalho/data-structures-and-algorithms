# Hash tables
- Also called Dictionaries
- Give super-fast lookups, which allow to optimize a lot of algorithms

## Usage
- Spell checkers
- Compilers
- Dictionaries
- Code editores
- Literally anywhere you want to lookup an item very fast

## How they work
- At very high level, hash tables are used to store a pairs of key-value

* key -> hashfunction(key) -> address of value of the value

- Hash function is deterministic, everytime with pass a key we always get the same value. It works for storing/retrivieng objecgts

## Operations

- Insert O(1)
- Lookup O(1) 
- Delete O(1)

* They run in O(1) since the hash function returns the address of the objects stored in the table.

## Notes

- We cannot have duplicate keys
- They also accept null keys and values
- contains.Key() -> O(1)
- contains.Value() -> O(n) - it needs to iterate trough all the items and compare each one with the value
- items are not inserted sequentally in memory, the hash function will figure out where to be inserted


# Sets
- Only have keys, they don't have values
- They're very useful, because they don't allow duplicate keys, we will end up with an unique list of items


# First Non-repetead character -> Hast tables
# First repetead character -> Sets

# Hash functions
- Mapping an index value with an array position

# Collision 
- Two keys or more poiting to the same hash value
- To solve this problem we can use:
    - chaining: adding a linked list, were we append the second object (storing in a linked list, not in a cell)
    - open addressing: point the second key to another address, which is result of probing all the slots and find one that is empty

## Chaining

- Using a linked list to store multiple items at the same array index
- With this approach we no longer have collisions and the linked list can grow automatically

## Open addressing

- We don't store values in linked lists, we store the items directly in the array cells.
- If we achieve an occupied slot, we need to probing. In other words, finding an new empty slot on the array of values.
- The address of the value is not determined by the hash function, because we need to search an empty slot.

### Open addressing linear
- We start in the current slot, and search in the next slots. We go forward until we got an empty slot
- Array ful, is a drawback of the open addressing because we cannot add more slots. On chaining, linked list can shrink/grow automacitcally.

- Clusters -> sections of cells occupied which make the probing slower.

 * (hash(key) + i) % table_size

### Open addressing quadratic
* (hash(key) + i^2) % table size
- solves the clustering. However, can generate loops.

### Open addressing double hashing
* (has1(key) + i*hash2(key)) % table_size