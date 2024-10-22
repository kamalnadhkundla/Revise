import os
import time
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler
import subprocess

class ChangeHandler(FileSystemEventHandler):
    def on_any_event(self, event):
        # When any event is detected, commit and push changes to Git
        print(f"Changes detected: {event.src_path}")
        subprocess.run(['git', 'add', '.'])
        subprocess.run(['git', 'commit', '-m', 'Auto commit: changes detected in the Java files'])
        subprocess.run(['git', 'push', 'origin', 'main'])  # Adjust branch as needed

def monitor_folder(repo_dir):
    # Initialize observer to monitor the directory
    event_handler = ChangeHandler()
    observer = Observer()
    observer.schedule(event_handler, path=repo_dir, recursive=True)
    observer.start()
    try:
        while True:
            time.sleep(5)
    except KeyboardInterrupt:
        observer.stop()
    observer.join()

if __name__ == "__main__":
    repo_dir = "/Users/kamalnadhkundla/Desktop/Problems"
    os.chdir(repo_dir)
    monitor_folder(repo_dir)
