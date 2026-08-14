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

# Install required extensions
USER coder

RUN code-server --install-extension redhat.java && \
    code-server --install-extension vscjava.vscode-java-debug && \
    code-server --install-extension bierner.markdown-preview-github-styles

# Create classroom workspace and VS Code settings
USER root

RUN mkdir -p \
    /home/coder/project \
    /home/coder/.local/share/code-server/User && \
    chown -R coder:coder /home/coder

COPY settings.json /home/coder/.local/share/code-server/User/settings.json

COPY classroom-entrypoint.sh /usr/local/bin/classroom-entrypoint.sh
RUN chmod +x /usr/local/bin/classroom-entrypoint.sh

COPY classroom-extension /home/coder/.local/share/code-server/extensions/classroom-logout

RUN chown -R coder:coder \
    /home/coder/.local/share/code-server

USER coder

WORKDIR /home/coder/project

EXPOSE 8080

ENTRYPOINT ["/usr/local/bin/classroom-entrypoint.sh"]

CMD ["code-server", \
    "--bind-addr", "0.0.0.0:8080", \
    "--disable-telemetry", \
    "/home/coder/project"]