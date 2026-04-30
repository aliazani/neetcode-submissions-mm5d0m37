class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        # Transform string to handle even/odd lengths uniformly
        # Example: "abba" becomes "#a#b#b#a#"
        transformed_string = "#" + "#".join(s) + "#"

        # This array stores the radius of the longest palindrome found at each center index
        radii = [0] * len(transformed_string)
        
        # The "Flashlight" variables:
        # center: The index of the palindrome that stretches furthest to the right.
        # right: The absolute right-most boundary index of that palindrome.
        center = 0
        right = 0
        
        # Variables to keep track of the longest palindrome we find overall
        max_radius = 0
        best_center = 0

        for current_index in range(len(transformed_string)):
            # Calculate the mirror index of our current position relative to the 'center'
            mirror_index = (2 * center) - current_index

            # --- 1. THE MIRROR SHORTCUT ---
            if current_index < right:
                # We are standing inside the safe, known right boundary.
                # Copy the radius from the mirror, but cap it so it doesn't exceed the right boundary.
                radii[current_index] = min(right - current_index, radii[mirror_index])

            # --- 2. MANUAL EXPANSION ---
            # Set up our left and right pointers just outside our currently known radius
            expand_left = current_index - radii[current_index] - 1
            expand_right = current_index + radii[current_index] + 1

            # While our pointers are inside the string, and the characters match:
            while (expand_left >= 0 and 
                   expand_right < len(transformed_string) and 
                   transformed_string[expand_left] == transformed_string[expand_right]):
                
                radii[current_index] += 1  # Grow the radius
                expand_left -= 1           # Move left pointer outward
                expand_right += 1          # Move right pointer outward

            # --- 3. PUSH THE BOUNDARY ---
            # If our newly built palindrome stretches further right than the old boundary,
            # it becomes our new main reference point.
            if current_index + radii[current_index] > right:
                center = current_index
                right = current_index + radii[current_index]

            # --- 4. TRACK THE OVERALL WINNER ---
            if radii[current_index] > max_radius:
                max_radius = radii[current_index]
                best_center = current_index

        # --- 5. EXTRACT THE RESULT ---
        # Map our findings back to the original string indices
        start_index = (best_center - max_radius) // 2
        
        return s[start_index : start_index + max_radius]