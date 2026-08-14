const vscode = require('vscode');

function activate(context) {
    // 1. Register explicit logout command
    const logoutCmd = vscode.commands.registerCommand('classroom.logout', () => {
        performLogout();
    });
    context.subscriptions.push(logoutCmd);

    // 2. Add visible Logout button in Status Bar
    const statusBarItem = vscode.window.createStatusBarItem(
        vscode.StatusBarAlignment.Right,
        10000
    );
    statusBarItem.command = 'classroom.logout';
    statusBarItem.text = '$(sign-out) Logout / Close';
    statusBarItem.tooltip = 'Close editor and reset all session cookies';
    statusBarItem.show();
    context.subscriptions.push(statusBarItem);

    // 3. Listen for workspace folder close (File -> Close Folder)
    const folderListener = vscode.workspace.onDidChangeWorkspaceFolders(event => {
        if (!vscode.workspace.workspaceFolders || vscode.workspace.workspaceFolders.length === 0) {
            performLogout();
        }
    });
    context.subscriptions.push(folderListener);

    // 4. If loaded with no workspace folder open
    if (!vscode.workspace.workspaceFolders || vscode.workspace.workspaceFolders.length === 0) {
        setTimeout(() => {
            if (!vscode.workspace.workspaceFolders || vscode.workspace.workspaceFolders.length === 0) {
                performLogout();
            }
        }, 1500);
    }
}

function performLogout() {
    vscode.env.openExternal(vscode.Uri.parse('/__classroom/logout'));
}

function deactivate() {}

module.exports = {
    activate,
    deactivate
};
