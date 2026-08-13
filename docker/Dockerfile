FROM codercom/code-server:latest

USER root

# Install Java only
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    openjdk-25-jdk-headless \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Java environment
ENV JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Install only required Java extensions
USER coder

RUN code-server --install-extension redhat.java && \
    code-server --install-extension vscjava.vscode-java-debug

# Create classroom workspace and VS Code settings
USER root

RUN mkdir -p \
    /home/coder/project \
    /home/coder/.local/share/code-server/User && \
    chown -R coder:coder /home/coder

COPY settings.json /home/coder/.local/share/code-server/User/settings.json

RUN chown coder:coder \
    /home/coder/.local/share/code-server/User/settings.json

USER coder

WORKDIR /home/coder/project

EXPOSE 8080

CMD ["code-server", \
    "--bind-addr", "0.0.0.0:8080", \
    "--disable-telemetry", \
    "/home/coder/project"]