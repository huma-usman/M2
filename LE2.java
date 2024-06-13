// Define constants
const MAX_CANDIDATES = 5          // Maximum number of candidates
const THRESHOLD_PERCENTAGE = 50   // Threshold percentage for majority

// Define arrays and variables
array NAMES[MAX_CANDIDATES]   // Array to store candidate names
array VOTES[MAX_CANDIDATES]   // Array to store number of votes for each candidate

int TOTAL_VOTES     // Total number of votes cast
int MAX_VOTES1, MAX_VOTES2   // Variables to store highest and second highest votes
int INDEX1, INDEX2   // Index variables for candidates with MAX_VOTES1 and MAX_VOTES2

// Function to read input votes for each candidate
function readVotes():
    TOTAL_VOTES = 0
    for i = 0 to MAX_CANDIDATES-1 do
        VOTES[i] = readInput()    // Read input votes for each candidate
        TOTAL_VOTES = TOTAL_VOTES + VOTES[i]   // Calculate total votes
    end for

// Function to determine winners
function determineWinners():
    MAX_VOTES1 = -1
    MAX_VOTES2 = -1

    for i = 0 to MAX_CANDIDATES-1 do
        if VOTES[i] > MAX_VOTES1 then
            MAX_VOTES2 = MAX_VOTES1   // Update second highest votes
            INDEX2 = INDEX1           // Update index of second highest
            MAX_VOTES1 = VOTES[i]     // Update highest votes
            INDEX1 = i               // Update index of highest
        else if VOTES[i] > MAX_VOTES2 then
            MAX_VOTES2 = VOTES[i]     // Update second highest votes
            INDEX2 = i               // Update index of second highest
        end if
    end for

// Function to output the result
function outputResult():
    if MAX_VOTES1 > TOTAL_VOTES / 2 then
        output "Candidate ", NAMES[INDEX1], " is elected as president."
    else
        output "There will be a second round between candidates ", NAMES[INDEX1], " and ", NAMES[INDEX2], "."
    end if

// Main program
function main():
    // Step 1: Assign names (example)
    NAMES[0] = "Candidate A"
    NAMES[1] = "Candidate B"
    // ... Assign names for other candidates if needed

    // Step 2: Read votes
    readVotes()

    // Step 3: Determine winners
    determineWinners()

    // Step 4: Output result
    outputResult()

end function
