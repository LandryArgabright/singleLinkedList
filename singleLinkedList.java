package com.company;

import java.util.Random;

class singlyLinkedList<E> {

        private Node<E> head = null;
        private int size = 0;

        //region  Data Structures Assignment Methods

        /*
        returns size of singly Linked List
         */
        public int getSize()
        {
            return size;
        }

        /* method getIndex
        Searches the list for the first occurrence of “value”
            returns its index position
            or -1 if not found
                (zero based index)
         */
        public int getIndex(E value)
        {
            Node <E> node = head;

            if(size > 0) {
                for (int i = 0; i < size; i++) {
                    if (node.data == value) {
                        return i;
                    }
                    node = node.next;
                }
            }

            return -1;
        }

        /* method public remove
        Removes the entry at position “index”
        returns its data
         */
        public E remove(int index)
        {
            // get data
            E result = getNode(index).data;

            //remove node at index
            // by calling getNode - 1
            removeAfter(getNode(index-1));

            // return result
            return result;

        }

        /* method randomRemove
            randomly removes node
            returns the data from removed node
         */
        public E randomRemove()
        {
            // generate random number
            int rand =  new Random().nextInt(size);
            // grab node at random index
            Node<E> garbageNode = getNode(rand);
            // store node's data
            E garbageResult = garbageNode.data;
            // throw out the garbageNode
            if(rand == 0)
            {
                // helper function remove first Node
                removeFirst();
            }
            else
            {
                // helper functionS
                //  first grab node at index before rand
                //      second remove node after grabbed node
                removeAfter(getNode(rand - 1));
            }

            return garbageResult;

        }

        /* method toString
            loops through list
            grabs all items & casts them to String type
            return string of all string casted items
         */
        @Override
        public String toString()
        {
            // starting node
            Node<E> node = head;
            // string to hold all data
            String result = "\nStart toString(): \n";

            for(int i = 0; i < size; i++)
            {
                result += node.data + "\n";
                node = node.next;
            }

            return result;
        }


        //TODO:
        /* Method Concat
        Merge two linked lists together
        concat second onto the first
        The original lists should not changed
         */

        public singlyLinkedList<E> concat(singlyLinkedList<E> second) {
            // New empty List to add values
            singlyLinkedList<E> newList = new singlyLinkedList<>();

            // Pointers for first & second lists
            Node<E> firstListNode = head;
            Node<E> secondListNode = second.head;

            // SAFETY CHECK!!!
            // if head node of first list is empty don't continue past this point
            if(firstListNode == null)
            {
                // empty first list add second list and get out

                // while there is data in node in second list
                while(secondListNode.data != null)
                {
                    // add data to merged list
                    newList.add(secondListNode.data);
                    // if node's next is null do not change pointer
                    if(secondListNode.next == null)
                    {
                        // break loop
                        break;
                    }
                    else {
                        // node's next has value -> move pointer
                        secondListNode = secondListNode.next;
                    }
                }
                return newList;
            }



            // while there is data in node in first list
            while(firstListNode.data != null)
            {
                // add data to merged List
                newList.add(firstListNode.data);
                // if node's next is null do not change pointer
                if(firstListNode.next == null)
                {
                    // break loop
                    break;
                }else {
                    // node's next has value -> move pointer forward
                    firstListNode = firstListNode.next;
                }
            }

            // SECOND SAFTEY CHECK!!!
            // if head node of second list is empty don't continue past this point
            if(secondListNode == null)
            {
                return newList;
            }



            // while there is data in node in second list
            while(secondListNode.data != null)
            {
                // add data to merged list
                newList.add(secondListNode.data);
                // if node's next is null do not change pointer
                if(secondListNode.next == null)
                {
                    // break loop
                    break;
                }
                else {
                    // node's next has value -> move pointer
                    secondListNode = secondListNode.next;
                }
            }

            // return new merged List
            return newList;
        }




        //endregion

        //region Public Methods

        //using helper method return node at input index
        public E get(int index)
        {
            if(index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }

            return getNode(index).data;
        }

        // set node value at given index
        public E set(int index, E newValue)
        {
            if(index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }

            // get node with helper method
            Node<E> node = getNode(index);

            // grab old data
            E data = node.data;
            //replace old data
            node.data = newValue;

            //return old data
            return data;
        }

        // Add node at index value
        public void add(int index, E value)
        {
            if(index < 0 || index > size)
            {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }

            //if input is for first node in list
            if(index == 0)
            {
                // add data to first node in list
                addFirst(value);
            }
            else
            {
                // add node at index using addAfter helper method
                addAfter(getNode(index - 1), value);
            }
        }

        // add value to end of singly linked list
        public boolean add(E value)
        {
            // size is last element in list
            // add value after last element in list
            add(size, value);

            return true;
        }

        //endregion

        //region Private Methods

        // input item
        // return void
        private void addFirst(E item)
        {
            // add node to head position
            head = new Node<E>(item, head);
            // increment size
            size++;
        }


        //add node after given node
        //      input data = item
        private void addAfter(Node<E> node, E item)
        {
            // adding new node to after input node
            node.next = new Node<>(item, node.next);
            // increment size of list
            size++;
        }


        // remove node after node input
        private E removeAfter(Node<E> node)
        {
            // temporary node
            Node<E> temp = node.next;

            if(temp  != null)
            {
                // node changes next to the node after removed node
                //      garbage collector will take care of unlinked nodes
                node.next = temp.next;
                // decrement size
                size--;
                return temp.data;
            }
            else
            {
                return null;
            }
        }

        // remove first node in list
        private E removeFirst()
        {
            // temporary node
            Node<E> temp = head;


            if(head != null)
            {
                // head is now node after head
                head = head.next;
            }

            if(temp != null)
            {
                size--;
                return temp.data;
            }
            else
            {
                return null;
            }
        }

        // get node at index
        private Node<E> getNode(int index)
        {
            // temporary node
            Node<E> node = head;

            // iterate through sinlgy linked list
            //      until i == index
            for(int i = 0; i < index; i++)
            {
                node = node.next;
            }

            return node;
        }
        //endregion

        // Node class
        private static class Node<E>
        {
            // two characteristics of Node object
            //      hold data of any type
            private E data;
            //      point to next node in line (if there is one)
            private Node<E> next;

            // Constructor
            //      make node with data
            private Node(E dataItem)
            {
                data = dataItem;
                next = null;
            }

            // Constructor
            //      make node with next and data characteristics
            private Node(E dataItem, Node<E> nodeRef)
            {
                data = dataItem;
                next = nodeRef;
            }
        }



}

