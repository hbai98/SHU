# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.16

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\environment\jetbrains\CLion 2019.2.1\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\environment\jetbrains\CLion 2019.2.1\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\Development\SHU\Openmp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\Development\SHU\Openmp\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Openmp.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Openmp.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Openmp.dir/flags.make

CMakeFiles/Openmp.dir/main.cpp.obj: CMakeFiles/Openmp.dir/flags.make
CMakeFiles/Openmp.dir/main.cpp.obj: CMakeFiles/Openmp.dir/includes_CXX.rsp
CMakeFiles/Openmp.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\Development\SHU\Openmp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Openmp.dir/main.cpp.obj"
	D:\environment\programming\mingw\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Openmp.dir\main.cpp.obj -c D:\Development\SHU\Openmp\main.cpp

CMakeFiles/Openmp.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Openmp.dir/main.cpp.i"
	D:\environment\programming\mingw\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\Development\SHU\Openmp\main.cpp > CMakeFiles\Openmp.dir\main.cpp.i

CMakeFiles/Openmp.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Openmp.dir/main.cpp.s"
	D:\environment\programming\mingw\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\Development\SHU\Openmp\main.cpp -o CMakeFiles\Openmp.dir\main.cpp.s

# Object files for target Openmp
Openmp_OBJECTS = \
"CMakeFiles/Openmp.dir/main.cpp.obj"

# External object files for target Openmp
Openmp_EXTERNAL_OBJECTS =

Openmp.exe: CMakeFiles/Openmp.dir/main.cpp.obj
Openmp.exe: CMakeFiles/Openmp.dir/build.make
Openmp.exe: CMakeFiles/Openmp.dir/linklibs.rsp
Openmp.exe: CMakeFiles/Openmp.dir/objects1.rsp
Openmp.exe: CMakeFiles/Openmp.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\Development\SHU\Openmp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Openmp.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Openmp.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Openmp.dir/build: Openmp.exe

.PHONY : CMakeFiles/Openmp.dir/build

CMakeFiles/Openmp.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Openmp.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Openmp.dir/clean

CMakeFiles/Openmp.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\Development\SHU\Openmp D:\Development\SHU\Openmp D:\Development\SHU\Openmp\cmake-build-debug D:\Development\SHU\Openmp\cmake-build-debug D:\Development\SHU\Openmp\cmake-build-debug\CMakeFiles\Openmp.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Openmp.dir/depend

