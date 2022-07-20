1st -- Create a hashmap of <char, Queue or ArrayList> type which is going to have a key of type char which is all the char that is present in the string s.

2nd -- put all the words which start from that char in their respective key's entries.

3rd -- iterate over the string s and everytime check if we have any words there in the hashmap corresponding to this char and take all of the values out and one by one delete the first char of the words and put them into different key according to the new starting char of that word in the hashmap and if after deleting the first character the string becomes empty that means we have found one subsequence in the string s and we just increment the ans variable by one. at last just return ans after processing the entire string s.
