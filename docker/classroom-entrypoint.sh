#!/bin/bash

# ---------------------------------------------------------------
# classroom-entrypoint.sh
#
# Generates Eclipse .project and .classpath files in each
# subdirectory of the student workspace so JDT Language Server
# treats each folder (Question-1, Question-2, ...) as a separate
# Java project with its own compilation output (bin/).
#
# This prevents multiple Main.java files from colliding into a
# single bin/Main.class.
#
# After generating project files, it delegates to the original
# code-server entrypoint.
# ---------------------------------------------------------------

PROJECT_DIR="/home/coder/project"

for dir in "$PROJECT_DIR"/*/; do

    # Skip if not a directory
    [ -d "$dir" ] || continue

    basename=$(basename "$dir")

    # Skip hidden directories (.vscode, .git, etc.)
    [[ "$basename" == .* ]] && continue

    # Create .project if missing
    if [ ! -f "$dir/.project" ]; then
        cat > "$dir/.project" << PROJ
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
    <name>${basename}</name>
    <comment></comment>
    <projects></projects>
    <buildSpec>
        <buildCommand>
            <name>org.eclipse.jdt.core.javabuilder</name>
            <arguments></arguments>
        </buildCommand>
    </buildSpec>
    <natures>
        <nature>org.eclipse.jdt.core.javanature</nature>
    </natures>
</projectDescription>
PROJ
    fi

    # Create .classpath if missing
    if [ ! -f "$dir/.classpath" ]; then
        cat > "$dir/.classpath" << CLSP
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="src" path="."/>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
    <classpathentry kind="output" path="bin"/>
</classpath>
CLSP
    fi

done

# Hand off to the original code-server entrypoint
exec /usr/bin/entrypoint.sh "$@"
